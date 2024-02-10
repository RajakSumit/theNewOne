package com.NewBlog.NewBlog11.service.impl;

import com.NewBlog.NewBlog11.Entity.Comment;
import com.NewBlog.NewBlog11.Entity.Post;
import com.NewBlog.NewBlog11.exception.ResourceNotFoundException;
import com.NewBlog.NewBlog11.payload.CommentDto;
import com.NewBlog.NewBlog11.repository.CommentRepository;
import com.NewBlog.NewBlog11.repository.PostRepository;
import com.NewBlog.NewBlog11.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow
                (() -> new ResourceNotFoundException("Post Not Found By Id: " + id));

        Comment comments = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found By Id: " + id));

        Comment c = mapToEntity(commentDto);
        c.setId(comments.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);

        CommentDto dto = mapToDto(savedComment);

        return dto;
    }

    CommentDto mapToDto(Comment comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;

    }

    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;

    }

}
