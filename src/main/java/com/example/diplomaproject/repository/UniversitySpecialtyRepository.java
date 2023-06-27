package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.UniversitySpecialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversitySpecialtyRepository  extends JpaRepository<UniversitySpecialty, Long> {
    List<UniversitySpecialty> findUniversitySpecialtiesByUniversityId(Long universityId);
    List<UniversitySpecialty> findUniversitySpecialtiesBySpecialtyId(Long specialtyId);

}
