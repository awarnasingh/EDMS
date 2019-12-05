package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.edms.core.domain.SearchHistory;


/**
 * Spring Data  repository for the SearchHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    @Query(value = "select * from edms.search_history where search_name = :name", nativeQuery = true)
	List<SearchHistory> findBySearchHistoryName(@Param("name") String name);
}
