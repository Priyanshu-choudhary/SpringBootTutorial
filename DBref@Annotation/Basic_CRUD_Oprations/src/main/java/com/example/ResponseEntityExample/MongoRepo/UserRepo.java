package com.example.ResponseEntityExample.MongoRepo;

import com.example.ResponseEntityExample.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
