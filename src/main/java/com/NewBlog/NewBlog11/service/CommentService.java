package com.NewBlog.NewBlog11.service;

import com.NewBlog.NewBlog11.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long postId);
}