package com.ff.revision.revisionProject.repository;

import com.ff.revision.revisionProject.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
}
