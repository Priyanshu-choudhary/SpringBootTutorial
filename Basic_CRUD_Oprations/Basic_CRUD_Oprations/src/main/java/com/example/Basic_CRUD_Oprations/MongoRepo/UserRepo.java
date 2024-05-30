package com.example.Basic_CRUD_Oprations.MongoRepo;

import com.example.Basic_CRUD_Oprations.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
