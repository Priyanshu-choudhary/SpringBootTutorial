package com.example.DBrefAnnotation.MongoRepo;

import com.example.DBrefAnnotation.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByName(String name);
}
