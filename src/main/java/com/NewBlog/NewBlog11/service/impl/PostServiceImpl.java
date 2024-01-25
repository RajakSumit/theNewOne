package com.NewBlog.NewBlog11.service.impl;

import com.NewBlog.NewBlog11.Entity.Post;
import com.NewBlog.NewBlog11.exception.ResourceNotFoundException;
import com.NewBlog.NewBlog11.payload.PostDto;
import com.NewBlog.NewBlog11.repository.PostRepository;
import com.NewBlog.NewBlog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setDepartment(postDto.getDepartment());
        post.setName(postDto.getName());
        Post savedPost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setId(savedPost.getId());
        dto.setDepartment(savedPost.getDepartment());
        dto.setName(savedPost.getName());
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id:" + id)
        );

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setDepartment(post.getDepartment());
        dto.setName(post.getName());

        return dto;
    }


    }


