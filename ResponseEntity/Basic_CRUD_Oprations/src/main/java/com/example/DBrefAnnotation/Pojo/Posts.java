package com.example.DBrefAnnotation.Pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Posts")
public class Posts {
    @Id
    private String title;
    private String content;
    private String imgUrl;




}
