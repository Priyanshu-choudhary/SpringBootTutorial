package com.example.WebSecurityExample.controller;

import com.example.WebSecurityExample.Pojo.User;
import com.example.WebSecurityExample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("api")
    public String sayHello(){
        return "Hello test";
    }

    @PostMapping("/Create-User")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            userService.createNewUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
