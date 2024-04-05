package com.bibek.blog.controllers;

import com.bibek.blog.entities.Post;
import com.bibek.blog.payloads.PostDto;
import com.bibek.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
            ){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(
            @PathVariable Integer userId
    ){
        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }


    //get by category
    @GetMapping("/category/{caregoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(
            @PathVariable Integer caregoryId
    ){
        List<PostDto> posts = this.postService.getPostByCategory(caregoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

}
