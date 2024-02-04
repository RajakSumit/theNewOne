package com.NewBlog.NewBlog11.repository;

import com.NewBlog.NewBlog11.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
