package com.example.TransactionalAnnotation.Service;

import com.example.TransactionalAnnotation.MongoRepo.PostRepo;
import com.example.TransactionalAnnotation.Pojo.Posts;
import com.example.TransactionalAnnotation.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserService userService;

    public List<Posts> getAllUsers() {
        return postRepo.findAll();
    }

    public Optional<Posts> getUserById(String id) {
        return postRepo.findById(id);
    }
    @Transactional
    public void createUser(Posts posts,String inputuser) {
        try{
            User myuser = userService.findByName(inputuser);//get user

            Posts saved= postRepo.save(posts);//saved in posts DB
            myuser.getPosts().add(saved);

            userService.createUser(myuser);//saved in user DB(creating ref)
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("an error occur while saving an entry",e);
        }
    }

    public void deleteUserById(String id, String name) {
        User myuser = userService.findByName(name);
        myuser.getPosts().removeIf(x ->x.getId().equals(id));
        userService.createUser(myuser);
        postRepo.deleteById(id);
    }



}
