package com.jsolisg.vmaze_middelware.percistence.repository;

import com.jsolisg.vmaze_middelware.percistence.document.ShowDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<ShowDocument, Long> {
}
