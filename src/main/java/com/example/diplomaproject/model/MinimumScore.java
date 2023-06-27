package com.example.diplomaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "minimum_score")
public class MinimumScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @Column(name = "minimum_score", nullable = false)
    private Integer minimumScore;

    @Column(name = "year", nullable = false)
    private Integer year;

    // constructors, getters, setters
}
