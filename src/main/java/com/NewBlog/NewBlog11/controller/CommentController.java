package com.NewBlog.NewBlog11.controller;

import com.NewBlog.NewBlog11.payload.CommentDto;
import com.NewBlog.NewBlog11.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/comment?postId=1

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @RequestParam long postId){

        CommentDto dto = commentService.createComment(commentDto, postId);

        return new ResponseEntity<>( dto , HttpStatus.CREATED);



    }


}
