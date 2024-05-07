package com.ff.revision.revisionProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "journal_entries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDate date;

}
