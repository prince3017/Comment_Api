package com.example.CommentApi.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private String commentTo;
    private String commentFrom;
    private String message;

}
