package com.bibek.blog.services.impl;

import com.bibek.blog.entities.Comment;
import com.bibek.blog.entities.Post;
import com.bibek.blog.exceptions.ResourceNotFoundException;
import com.bibek.blog.payloads.CommentDto;
import com.bibek.blog.repository.CommentRepo;
import com.bibek.blog.repository.PostRepo;
import com.bibek.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "comment id", commentId));
        this.commentRepo.delete(comment);
    }
}
