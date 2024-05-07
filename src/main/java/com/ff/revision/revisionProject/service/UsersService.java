package com.ff.revision.revisionProject.service;

import com.ff.revision.revisionProject.entity.Users;
import com.ff.revision.revisionProject.repository.JournalEntryRepository;
import com.ff.revision.revisionProject.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }

    public boolean deleteUsers(ObjectId id) {
        Users user = usersRepository.findById(id).orElse(null);
        usersRepository.delete(user);
        return true;
    }
}
