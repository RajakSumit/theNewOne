package com.NewBlog.NewBlog11.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Comments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    private String name;

    // Define Many-to-One relationship with Post
    @ManyToOne
    @JoinColumn(name = "post_id") // Define the foreign key column in the Comment table
    private Post post;
}
