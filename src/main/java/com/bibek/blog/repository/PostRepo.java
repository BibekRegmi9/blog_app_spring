package com.bibek.blog.repository;

import com.bibek.blog.entities.Category;
import com.bibek.blog.entities.Post;
import com.bibek.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
