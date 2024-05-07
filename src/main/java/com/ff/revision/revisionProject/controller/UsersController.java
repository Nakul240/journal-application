package com.ff.revision.revisionProject.controller;

import com.ff.revision.revisionProject.entity.Users;
import com.ff.revision.revisionProject.service.UsersService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping
    public Users saveUsers(@RequestBody Users users){
       return service.saveUsers(users);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUsers(@PathVariable ObjectId id){
        return service.deleteUsers(id);
    }

}
