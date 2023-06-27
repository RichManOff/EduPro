package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    List<University> findByNameContainingIgnoreCase(String name);

    List<University> findByLocationContainingIgnoreCase(String location);

    List<University> findFirst4ByOrderByIdAsc();

    @Query("SELECT u FROM University u WHERE u.name LIKE %:keyword% OR u.description LIKE %:keyword%")
    List<University> searchUniversities(@Param("keyword") String keyword);
}