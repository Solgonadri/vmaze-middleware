package com.jsolisg.vmaze_middelware.controller;

import com.jsolisg.vmaze_middelware.dto.CommentRequest;
import com.jsolisg.vmaze_middelware.dto.CommentResponse;
import com.jsolisg.vmaze_middelware.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> createComment(
            @Valid @RequestBody CommentRequest request) {

        CommentResponse response = commentService.createComment(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
