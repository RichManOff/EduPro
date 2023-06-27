package com.example.diplomaproject.model;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Review() {}

    public Review(User account, Course course, int rating, String comment) {
        this.account = account;
        this.course = course;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
    }

// Getters and Setters

}