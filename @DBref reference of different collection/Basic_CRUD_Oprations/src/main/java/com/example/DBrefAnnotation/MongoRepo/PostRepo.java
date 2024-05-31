package com.example.DBrefAnnotation.MongoRepo;

import com.example.DBrefAnnotation.Pojo.Posts;
import com.example.DBrefAnnotation.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Posts, String> {

}
