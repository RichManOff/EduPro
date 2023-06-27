package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistory> findSearchHistoriesByUserId(Long userId);

}
