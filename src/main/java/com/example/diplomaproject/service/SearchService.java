package com.example.diplomaproject.service;

import com.example.diplomaproject.model.SearchHistory;
import com.example.diplomaproject.model.SearchUniversity;
import com.example.diplomaproject.repository.SearchHistoryRepository;
import com.example.diplomaproject.repository.SearchUniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class SearchService {

    @Autowired
    SearchHistoryRepository searchHistoryRepository;

    @Autowired
    SearchUniversityRepository searchUniversityRepository;

    public void saveKeywords(Long userId, String keyword){
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setUserId(userId);
        searchHistory.setKeywords(keyword);
        searchHistory.setTimestamp(LocalDateTime.now());
        searchHistoryRepository.save(searchHistory);
    }

    public void saveUniversities(Long userId, Long universityId){
        SearchUniversity searchUniversity = new SearchUniversity();
        searchUniversity.setUserId(userId);
        searchUniversity.setUniversityId(universityId);
        searchUniversity.setTimestamp(LocalDateTime.now());
        searchUniversityRepository.save(searchUniversity);
    }

    public List<SearchUniversity> findUniversities(Long userId){
        return searchUniversityRepository.findSearchUniversitiesByUserId(userId);
    }

    public List<SearchHistory> findHistories(Long userId){
        return searchHistoryRepository.findSearchHistoriesByUserId(userId);
    }
}
