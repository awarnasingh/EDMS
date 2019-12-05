package com.edms.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

/**
 * Persist AuditEvent managed by the Spring Boot actuator.
 *
 * @see org.springframework.boot.actuate.audit.AuditEvent
 */
@Entity
@Table(name = "jhi_persistent_audit_event")
public class PersistentAuditEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String principal;

    @Column(name = "event_date")
    private Instant auditEventDate;

    @Column(name = "event_type")
    private String auditEventType;

    @Column(name = "logout_date")
    private Instant auditLogoutDate;

    @Column(name = "active_flag")
    private boolean active_flag;


    
    
    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "jhi_persistent_audit_evt_data", joinColumns=@JoinColumn(name="event_id"))
    private Map<String, String> data = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Instant getAuditEventDate() {
        return auditEventDate;
    }

    public void setAuditEventDate(Instant auditEventDate) {
        this.auditEventDate = auditEventDate;
    }

    public String getAuditEventType() {
        return auditEventType;
    }

    public void setAuditEventType(String auditEventType) {
        this.auditEventType = auditEventType;
    }
    
    
    public Instant getAuditLogoutDate() {
		return auditLogoutDate;
	}

	public void setAuditLogoutDate(Instant auditLogoutDate) {
		this.auditLogoutDate = auditLogoutDate;
	}


	public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    
    
    public boolean isActive_flag() {
		return active_flag;
	}

	public void setActive_flag(boolean active_flag) {
		this.active_flag = active_flag;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersistentAuditEvent persistentAuditEvent = (PersistentAuditEvent) o;
        return !(persistentAuditEvent.getId() == null || getId() == null) && Objects.equals(getId(), persistentAuditEvent.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "PersistentAuditEvent [id=" + id + ", principal=" + principal + ", auditEventDate=" + auditEventDate
				+ ", auditEventType=" + auditEventType + ", auditLogoutDate=" + auditLogoutDate + ", active_flag="
				+ active_flag + ", data=" + data + "]";
	}

	
	

   
}
