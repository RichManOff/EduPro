package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.SearchUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchUniversityRepository extends JpaRepository<SearchUniversity, Long> {
    List<SearchUniversity> findSearchUniversitiesByUserId(Long userId);
}
