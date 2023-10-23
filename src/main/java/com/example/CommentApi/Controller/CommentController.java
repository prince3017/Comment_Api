package com.example.CommentApi.Controller;

import com.example.CommentApi.Model.Comment;
import com.example.CommentApi.Model.CommentRequest;
import com.example.CommentApi.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public String addComment(@RequestBody CommentRequest request) {
        return commentService.addComment(request);
    }

    @GetMapping("/get")
    public List<Comment> getComments(@RequestParam String commentTo) {
        return commentService.getComments(commentTo);
    }
}
