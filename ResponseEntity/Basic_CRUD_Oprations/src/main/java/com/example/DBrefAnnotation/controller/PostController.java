package com.example.DBrefAnnotation.controller;

import com.example.DBrefAnnotation.Pojo.Posts;
import com.example.DBrefAnnotation.Pojo.User;
import com.example.DBrefAnnotation.Service.PostService;
import com.example.DBrefAnnotation.Service.UserService;
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

    @Autowired
    private UserService userService;


    @GetMapping
    public List<Posts> getAllUsers() {
        return postService.getAllUsers();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUserById(@PathVariable String name) {
        User users = userService.findByName(name);
        List<Posts> all=users.getPosts();
        if (all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping("{username}")
    public ResponseEntity<Posts> createUser(@RequestBody Posts user,@PathVariable String username) {
       try {
           postService.createUser(user,username);
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
