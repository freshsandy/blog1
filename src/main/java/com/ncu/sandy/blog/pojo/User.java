package com.ncu.sandy.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String image;
    private Timestamp createtime;

    public User(int id,String name,String email,String password)
    {

    }
}
