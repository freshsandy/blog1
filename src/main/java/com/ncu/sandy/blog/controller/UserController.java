package com.ncu.sandy.blog.controller;


import com.ncu.sandy.blog.dao.UserDao;
import com.ncu.sandy.blog.pojo.User;
import com.ncu.sandy.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;



    @RequestMapping("/login")
    public Map<String,String> DoLogin(@RequestParam(value="email") String email,
                                      @RequestParam(value="password") String password,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    {
        return userService.Login(email, password, request, response);
    }

   /* @RequestMapping("/show")
    public Map<String, User> ShowInfo(HttpServletRequest request)
    {
        return userService.showLoginInfo(request);
    }*/
}
