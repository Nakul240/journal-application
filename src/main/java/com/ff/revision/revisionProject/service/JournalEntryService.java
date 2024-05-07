package com.ff.revision.revisionProject.service;

import com.ff.revision.revisionProject.entity.JournalEntry;
import com.ff.revision.revisionProject.entity.Users;
import com.ff.revision.revisionProject.repository.JournalEntryRepository;
import com.ff.revision.revisionProject.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public JournalEntry saveJournalEntry(JournalEntry entry, String userName) {
        Users user = usersRepository.findByUserName(userName);
        entry.setDate(LocalDate.now());
        JournalEntry journalEntry = journalEntryRepository.save(entry);
        user.getJournalEntries().add(journalEntry);
        usersRepository.save(user);
        return journalEntry;
    }

    public List<JournalEntry> getAllJournalEntriesOfUser(String userName) {
        Users user = usersRepository.findByUserName(userName);
        return user.getJournalEntries();
    }


    public JournalEntry getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public JournalEntry updateJournalEntryById(String userName, ObjectId id, JournalEntry entry) {
        JournalEntry fetchedEntry = journalEntryRepository.findById(id).orElse(null);
        Users user = usersRepository.findByUserName(userName);
        if(fetchedEntry!=null && user!=null){
            fetchedEntry.setTitle(entry.getTitle()!=null && !(entry.getTitle().isEmpty()) ?entry.getTitle(): fetchedEntry.getTitle());
            fetchedEntry.setContent(entry.getContent()!=null && !(entry.getContent().isEmpty()) ?entry.getContent(): fetchedEntry.getContent());
        }
       return journalEntryRepository.save(fetchedEntry);
    }

    public boolean deleteJournalEntryById(String userName, ObjectId id) {
        boolean removed = false;
        Users user = usersRepository.findByUserName(userName);
        JournalEntry fetchedEntry = journalEntryRepository.findById(id).orElse(null);
        removed = user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
        if(removed){
            usersRepository.save(user);
            journalEntryRepository.delete(fetchedEntry);
        }
        return removed;
    }
}
