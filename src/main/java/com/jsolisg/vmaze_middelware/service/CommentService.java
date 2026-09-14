package com.jsolisg.vmaze_middelware.service;

import com.jsolisg.vmaze_middelware.dto.CommentRequest;
import com.jsolisg.vmaze_middelware.dto.CommentResponse;
import com.jsolisg.vmaze_middelware.percistence.document.CommentDocument;
import com.jsolisg.vmaze_middelware.percistence.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentResponse createComment(CommentRequest request) {

        CommentDocument document = new CommentDocument(
                null,
                request.show_id(),
                request.comment(),
                request.rating()
        );

        commentRepository.save(document);

        return new CommentResponse("comment created");
    }
}
