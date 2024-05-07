package com.ff.revision.revisionProject.controller;

import com.ff.revision.revisionProject.entity.JournalEntry;
import com.ff.revision.revisionProject.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    @Autowired
    private JournalEntryService service;

    @PostMapping("/{userName}")
    public JournalEntry saveJournalEntryUsingUserName(@PathVariable String userName, @RequestBody JournalEntry entry) {
        return service.saveJournalEntry(entry,userName);
    }

    @GetMapping("user/{userName}")
    public List<JournalEntry> getAllJournalEntriesOfUser(@PathVariable String userName) {
        return service.getAllJournalEntriesOfUser(userName);
    }

    @GetMapping("/{id}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId id) {
        return service.getJournalEntryById(id);
    }

    @PutMapping("user/{userName}/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable String userName,@PathVariable ObjectId id,@RequestBody JournalEntry entry) {
        return service.updateJournalEntryById(userName,id,entry);
    }

    @DeleteMapping("user/{userName}/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable String userName,@PathVariable ObjectId id) {
        return service.deleteJournalEntryById(userName,id);
    }
}
