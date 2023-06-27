package com.example.diplomaproject.service;

import com.example.diplomaproject.model.Comment;
import com.example.diplomaproject.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void save(String comment, int rating, Long universityId, Long userId){
        Comment commentObject;
        if (commentRepository.findCommentByUniversityIdAndUserId(universityId, userId) != null){
            commentObject = commentRepository.findCommentByUniversityIdAndUserId(universityId, userId);
        } else {
            commentObject = new Comment();
        }
        commentObject.setComment(comment);
        commentObject.setRating(rating);
        commentObject.setUniversityId(universityId);
        commentObject.setUserId(userId);
        commentRepository.save(commentObject);
    }
}
