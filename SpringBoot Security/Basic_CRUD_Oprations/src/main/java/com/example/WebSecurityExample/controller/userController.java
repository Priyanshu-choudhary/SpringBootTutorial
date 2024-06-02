package com.example.WebSecurityExample.controller;

import com.example.WebSecurityExample.MongoRepo.UserRepo;
import com.example.WebSecurityExample.Pojo.User;
import com.example.WebSecurityExample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User>  users= userService.getUserById(id);
        if (users.isPresent()) {
            return new ResponseEntity<>(users.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }



    @PutMapping
    public ResponseEntity<?>updateUserName(@RequestBody User user){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
       String username= auth.getName();
        User userIndb= userService.findByName(username);
        if(userIndb!=null){
            userIndb.setName(user.getName());
            userIndb.setPassword(user.getPassword());
        }
        userService.createNewUser(userIndb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        userService.deleteByName(auth.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
