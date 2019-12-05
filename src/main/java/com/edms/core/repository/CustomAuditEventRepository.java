package com.edms.core.repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.config.Constants;
import com.edms.core.config.audit.AuditEventConverter;
import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.PersistentAuditEvent;

/**
 * An implementation of Spring Boot's AuditEventRepository.
 */
@Repository
public class CustomAuditEventRepository implements AuditEventRepository {

	private static final String AUTHORIZATION_FAILURE = "AUTHORIZATION_FAILURE";
	static long FAILURE_COUNT = 0;
	static boolean ACTIVE_FLAG = false;
	/**
	 * Should be the same as in Liquibase migration.
	 */
	protected static final int EVENT_DATA_COLUMN_MAX_LENGTH = 255;

	@Autowired
	private UserRepository userRepository;

	private final PersistenceAuditEventRepository persistenceAuditEventRepository;

	private final AuditEventConverter auditEventConverter;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public CustomAuditEventRepository(PersistenceAuditEventRepository persistenceAuditEventRepository,
			AuditEventConverter auditEventConverter) {

		this.persistenceAuditEventRepository = persistenceAuditEventRepository;
		this.auditEventConverter = auditEventConverter;
	}

	@Override
	public List<AuditEvent> find(String principal, Instant after, String type) {
		Iterable<PersistentAuditEvent> persistentAuditEvents = persistenceAuditEventRepository
				.findByPrincipalAndAuditEventDateAfterAndAuditEventType(principal, after, type);
		return auditEventConverter.convertToAuditEvent(persistentAuditEvents);
	}

	@Override
	@Transactional // (propagation = Propagation.REQUIRES_NEW)
	public void add(AuditEvent event) {

		if (!AUTHORIZATION_FAILURE.equals(event.getType()) && !Constants.ANONYMOUS_USER.equals(event.getPrincipal())) {

			if (event.getType().equals(ConstantUtils.AUTHENTICATION_FAILURE)) {
				FAILURE_COUNT++;
				userRepository.findOneByLogin(event.getPrincipal()).map(user -> {
					// activate given user for the registration key.
					user.setAttempts(FAILURE_COUNT);
					log.debug("Activated user: {}", user);
					return user;
				});
			} else {
				FAILURE_COUNT = 0;
				ACTIVE_FLAG = true;
				userRepository.findOneByLogin(event.getPrincipal()).map(user -> {
					// activate given user for the registration key.
					user.setAttempts(FAILURE_COUNT);
					log.debug("Activated user: {}", user);
					return user;

				});
			}
			PersistentAuditEvent persistentAuditEvent = new PersistentAuditEvent();
			persistentAuditEvent.setPrincipal(event.getPrincipal());
			persistentAuditEvent.setAuditEventType(event.getType());
			persistentAuditEvent.setAuditEventDate(event.getTimestamp());
			persistentAuditEvent.setActive_flag(ACTIVE_FLAG);
			Map<String, String> eventData = auditEventConverter.convertDataToStrings(event.getData());
			persistentAuditEvent.setData(truncate(eventData));
			persistenceAuditEventRepository.save(persistentAuditEvent);

		}

	}

	/**
	 * Truncate event data that might exceed column length.
	 */
	private Map<String, String> truncate(Map<String, String> data) {
		Map<String, String> results = new HashMap<>();

		if (data != null) {
			for (Map.Entry<String, String> entry : data.entrySet()) {
				String value = entry.getValue();
				if (value != null) {
					int length = value.length();
					if (length > EVENT_DATA_COLUMN_MAX_LENGTH) {
						value = value.substring(0, EVENT_DATA_COLUMN_MAX_LENGTH);
						log.warn(
								"Event data for {} too long ({}) has been truncated to {}. Consider increasing column width.",
								entry.getKey(), length, EVENT_DATA_COLUMN_MAX_LENGTH);
					}
				}
				results.put(entry.getKey(), value);
			}
		}
		return results;
	}
}
