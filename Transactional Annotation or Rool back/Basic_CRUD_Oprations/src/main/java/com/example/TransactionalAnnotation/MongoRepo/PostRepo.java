package com.example.TransactionalAnnotation.MongoRepo;

import com.example.TransactionalAnnotation.Pojo.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Posts, String> {

}
