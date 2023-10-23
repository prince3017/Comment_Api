package com.example.CommentApi.Service;

import com.example.CommentApi.Model.Comment;
import com.example.CommentApi.Model.CommentRequest;
import com.example.CommentApi.Model.User;
import com.example.CommentApi.Repo.CommentRepository;
import com.example.CommentApi.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
/*@Service
public class CommentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public String addComment(CommentRequest request) {
        String commentTo = request.getCommentTo();
        String commentFrom = request.getCommentFrom();
        String message = request.getMessage();

        if (!isValidName(commentTo) || !isValidName(commentFrom) || message.isEmpty()) {
            return "Invalid Request";
        }

        User userTo = userRepository.findByCommentTo(commentTo);
        if (userTo == null) {
            userTo = new User();
            userTo.setCommentTo(commentTo);
            userTo.setCommentFrom(commentFrom);
            userRepository.save(userTo);
        }

        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setCommentDateTime(LocalDateTime.now());
        comment.setPostedByUser(userTo);
        commentRepository.save(comment);

        return "Comment added successfully";
    }
    public List<Comment> getComments(String commentTo) {
        User user = userRepository.findByCommentTo(commentTo);
        if (user != null) {
            return commentRepository.findByPostedByUserId(user.getUserId());
        } else {
            return Collections.emptyList();
        }
    }

    private boolean isValidName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }

        // Additional validation logic to check for special characters, numbers, etc.
        if (!userName.matches("^[a-zA-Z ]+$")) {
            return false;
        }
        return true;
    }

}*/



@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String addComment(CommentRequest request) {
        String commentTo = request.getCommentTo();
        String commentFrom = request.getCommentFrom();
        String message = request.getMessage();

        if (!isValidUserName(commentTo) || !isValidUserName(commentFrom) || message.isEmpty()) {
            return "Invalid Request";
        }

        User userTo = userRepository.findByCommentTo(commentTo);
        if (userTo == null) {
            userTo = new User();
            userTo.setCommentTo(commentTo);
            userTo.setCommentFrom(commentFrom);
            userRepository.save(userTo);
        }

        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setCommentDateTime(LocalDateTime.now());
        comment.setPostedByUser(userTo);
        commentRepository.save(comment);

        return "Comment added successfully";
    }

    public List<Comment> getComments(String commentTo) {
        User user = userRepository.findByCommentTo(commentTo);
        if (user != null) {
            return commentRepository.findByPostedByUserUserId(user.getUserId());
        } else {
            return Collections.emptyList();
        }
    }

    private boolean isValidUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }

        // Additional validation logic to check for special characters, numbers, etc.
        if (!userName.matches("^[a-zA-Z ]+$")) {
            return false;
        }

        return true;
    }
}


