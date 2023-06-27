package com.example.diplomaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private User account;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "bio")
    private String bio;

    // constructors, getters, and setters
}
