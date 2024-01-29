package com.NewBlog.NewBlog11.controller;


import com.NewBlog.NewBlog11.Entity.Post;
import com.NewBlog.NewBlog11.payload.PostDto;
import com.NewBlog.NewBlog11.service.PostService;
import com.NewBlog.NewBlog11.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
        //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED);

    }

    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto , HttpStatus.OK);


    }


//    http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=department&sortDir=desc
    @GetMapping
    public List<PostDto> getAllPost(
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", required = false, defaultValue = "3") String sortBY,
            @RequestParam(name = "sortDir", required = false, defaultValue = "3") String sortDir

    ){
        List<PostDto> postDtos = postService.getAllPost(pageNo , pageSize,  sortBY, sortDir);
        return postDtos;

    }

}
