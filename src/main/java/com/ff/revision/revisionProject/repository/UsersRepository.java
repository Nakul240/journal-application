package com.ff.revision.revisionProject.repository;

import com.ff.revision.revisionProject.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, ObjectId> {

     Users findByUserName(String name);
}
