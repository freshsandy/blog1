package com.ncu.sandy.blog.service;

import com.ncu.sandy.blog.pojo.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
    Map<String,String> Register(Map<String,Object> map);
    Map<String,String> Login(String email, String password,
                             HttpServletRequest request, HttpServletResponse response);
    Map<String, User> showLoginInfo(HttpServletRequest request);
}
