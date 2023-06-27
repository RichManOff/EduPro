package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Optional<Specialty> findById(Long id);

    Specialty save(Specialty specialty);

    void delete(Specialty specialty);

    @Query("SELECT s FROM Specialty s WHERE s.name LIKE %:keyword% OR s.description LIKE %:keyword%")
    List<Specialty> searchSpecialties(@Param("keyword") String keyword);

}
