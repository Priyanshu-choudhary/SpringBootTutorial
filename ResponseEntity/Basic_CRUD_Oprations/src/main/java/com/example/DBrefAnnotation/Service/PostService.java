package com.example.DBrefAnnotation.Service;

import com.example.DBrefAnnotation.MongoRepo.PostRepo;
import com.example.DBrefAnnotation.MongoRepo.UserRepo;
import com.example.DBrefAnnotation.Pojo.Posts;
import com.example.DBrefAnnotation.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public List<Posts> getAllUsers() {
        return postRepo.findAll();
    }

    public Optional<Posts> getUserById(String id) {
        return postRepo.findById(id);
    }

    public Posts createUser(Posts user) {
        return postRepo.save(user);
    }

    public void deleteUserById(String id) {
        postRepo.deleteById(id);
    }
}
