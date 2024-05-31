package com.example.WebSecurityExample.Pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Posts")
@NoArgsConstructor
public class Posts {
    @Id
    private String id;
    private String title;
    private String content;
    private String imgUrl;




}
