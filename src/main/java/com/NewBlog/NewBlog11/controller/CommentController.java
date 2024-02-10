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
    //    http://localhost:8080/api/comments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is Deleted", HttpStatus.OK);

    }

    //    http://localhost:8080/api/comments/1/post/1
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> UpdateComment( @PathVariable long id, @RequestBody CommentDto commentDto,@PathVariable long postId) {
        CommentDto dto = commentService.updateComment(id, commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);


    }
}
