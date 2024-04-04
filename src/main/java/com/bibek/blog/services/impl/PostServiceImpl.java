package com.bibek.blog.services.impl;

import com.bibek.blog.entities.Category;
import com.bibek.blog.entities.Post;
import com.bibek.blog.entities.User;
import com.bibek.blog.exceptions.ResourceNotFoundException;
import com.bibek.blog.payloads.PostDto;
import com.bibek.blog.repository.CategoryRepo;
import com.bibek.blog.repository.PostRepo;
import com.bibek.blog.repository.UserRepo;
import com.bibek.blog.services.PostService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Post createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User ", "User id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category ", "category id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, Post.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}