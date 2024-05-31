package com.example.DBrefAnnotation.Pojo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;

    // Getters and setters

}
