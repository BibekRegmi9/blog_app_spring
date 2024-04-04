package com.bibek.blog.services;

import com.bibek.blog.entities.Post;
import com.bibek.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto);

    Post updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostByCategory(Integer categoryId);

    List<Post> getPostByUser(Integer userId);

    List<Post> searchPost(String keyword);


}
