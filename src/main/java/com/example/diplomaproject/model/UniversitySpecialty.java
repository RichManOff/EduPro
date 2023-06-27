package com.example.diplomaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "university_specialty")
public class UniversitySpecialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "specialty_id")
    private Long specialtyId;

    public UniversitySpecialty(Long id, Long universityId, Long specialtyId) {
        this.id = id;
        this.universityId = universityId;
        this.specialtyId = specialtyId;
    }

    public UniversitySpecialty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }
}
