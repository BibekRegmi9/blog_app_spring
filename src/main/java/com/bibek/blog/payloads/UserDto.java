package com.bibek.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be minimum of 4 character")
    private String name;


    @Email(message = "Enter valid email address")
    private String email;

    @NotEmpty
    @Size(min = 8, max = 50, message = "Password length should be between 8 and 50 ")
//    @Pattern(regexp = )
    private String password;

    @NotEmpty
    private String about;
}
