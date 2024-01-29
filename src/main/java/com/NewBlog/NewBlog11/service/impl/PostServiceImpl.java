package com.NewBlog.NewBlog11.service.impl;

import com.NewBlog.NewBlog11.Entity.Post;
import com.NewBlog.NewBlog11.exception.ResourceNotFoundException;
import com.NewBlog.NewBlog11.payload.PostDto;
import com.NewBlog.NewBlog11.repository.PostRepository;
import com.NewBlog.NewBlog11.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

//        Post post = new Post();
//        post.setDepartment(postDto.getDepartment());
//        post.setName(postDto.getName());
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);

//        PostDto dto = new PostDto();
//        dto.setId(savedPost.getId());
//        dto.setDepartment(savedPost.getDepartment());
//        dto.setName(savedPost.getName());
        PostDto dto = mapToDto(savedPost);
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

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBY, String sortDir) {

        //  Using Ternary Operator
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();

        Pageable pageable =  PageRequest.of(pageNo,pageSize, sort);

//        Pageable pageable =  PageRequest.of(pageNo,pageSize, Sort.by(sortBY)); //this will short in ascending order
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();

        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());


        return dtos;
    }

     PostDto mapToDto(Post post) {
         PostDto dto = new PostDto();
         dto.setId(post.getId());
         dto.setDepartment(post.getDepartment());
         dto.setName(post.getName());
         return dto;
    }

     Post mapToEntity(PostDto postDto){
         Post post = new Post();
         post.setDepartment(postDto.getDepartment());
         post.setName(postDto.getName());
         return post;


     }


}


