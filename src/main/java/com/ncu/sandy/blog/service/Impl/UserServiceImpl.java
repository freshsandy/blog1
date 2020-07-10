package com.ncu.sandy.blog.service.Impl;

import com.ncu.sandy.blog.dao.UserDao;
import com.ncu.sandy.blog.pojo.User;
import com.ncu.sandy.blog.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserDao userDao;

    @Override
    public Map<String,String> Register(Map<String, Object> map) {
        Map<String,String> res = new HashMap<>();

        return res;
    }

    @Override
    public Map<String,String> Login(String email, String password,
                                     HttpServletRequest request, HttpServletResponse response) {

        Map<String,String> res = new HashMap<>();
        res.put("login","false");
        int uid = userDao.queryUser(email,password);//若成功返回的是用户id，失败则是0；
        if (uid > 0) {
            res.put("login", "success");
            User u = new User();
            u = userDao.getUser(uid);
            addSession(u,request);
        }
        return res;
    }

    /**
     *
     * @param user
     * @param request
     * 将登录成功后的信息加入到session中
     */
    public void addSession(User user,HttpServletRequest request)
    {
        request.getSession().setAttribute("user",user);
    }

    @Override
    public Map<String, User> showLoginInfo(HttpServletRequest request) {
        Map<String,User> res = new HashMap<>();
        res.put("UserInfo",(User)request.getSession().getAttribute("user"));
        return res;
    }
}
