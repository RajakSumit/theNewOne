package com.NewBlog.NewBlog11.service;

import com.NewBlog.NewBlog11.payload.PostDto;

import java.util.List;

public interface PostService {


    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);


    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBY, String sortDir);
}
