package com.NewBlog.NewBlog11.service;

import com.NewBlog.NewBlog11.payload.PostDto;

public interface PostService {


    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);


}
