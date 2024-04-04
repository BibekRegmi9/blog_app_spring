package com.bibek.blog.payloads;

import com.bibek.blog.entities.Category;
import com.bibek.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private Category category;

    private User user;

}