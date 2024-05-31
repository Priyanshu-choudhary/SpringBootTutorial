package com.example.TransactionalAnnotation.MongoRepo;

import com.example.TransactionalAnnotation.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByName(String name);
}
