package com.example.DBrefAnnotation.controller;

import com.example.DBrefAnnotation.Pojo.Posts;
import com.example.DBrefAnnotation.Pojo.User;
import com.example.DBrefAnnotation.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Posts")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping
    public List<Posts> getAllUsers() {
        return postService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getUserById(@PathVariable String id) {
        Optional<Posts>  users= postService.getUserById(id);
        if (users.isPresent()) {
            return new ResponseEntity<>(users.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Posts> createUser(@RequestBody Posts user) {
       try {
           postService.createUser(user);
           return new ResponseEntity<>(user,HttpStatus.CREATED);
       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        Optional<Posts>  users= postService.getUserById(id);
        if (users.isPresent()) {
            postService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

}
