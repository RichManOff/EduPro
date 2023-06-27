package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUniversityId(Long universityId);
    List<Course> findBySpecialtyId(Long specialtyId);
}


