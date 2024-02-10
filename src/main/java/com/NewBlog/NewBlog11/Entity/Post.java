package com.NewBlog.NewBlog11.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Employees")
@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String department;


    // Define One-to-Many relationship with Comment
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;





}
