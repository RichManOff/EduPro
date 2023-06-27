package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByUniversityIdAndUserId(Long universityId, Long userId);
}
