package com.jsolisg.vmaze_middelware.percistence.repository;

import com.jsolisg.vmaze_middelware.percistence.document.CommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<CommentDocument, String> {
    List<CommentDocument> findByShowId(Long showId);
    List<CommentDocument> findByShowIdIn(List<Long> showIds);
}
