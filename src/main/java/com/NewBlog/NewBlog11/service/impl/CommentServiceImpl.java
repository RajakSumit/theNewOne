package com.NewBlog.NewBlog11.service.impl;

import com.NewBlog.NewBlog11.Entity.Comment;
import com.NewBlog.NewBlog11.Entity.Post;
import com.NewBlog.NewBlog11.exception.ResourceNotFoundException;
import com.NewBlog.NewBlog11.payload.CommentDto;
import com.NewBlog.NewBlog11.repository.CommentRepository;
import com.NewBlog.NewBlog11.repository.PostRepository;
import com.NewBlog.NewBlog11.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found With Id:" + postId)
        );

        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setName(savedComment.getName());
        dto.setText(savedComment.getText());

        return dto;
    }
}
