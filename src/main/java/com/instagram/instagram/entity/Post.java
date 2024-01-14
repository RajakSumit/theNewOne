package com.instagram.instagram.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String title;
    private String description;

    private String content;

}
