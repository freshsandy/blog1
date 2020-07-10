package com.ncu.sandy.blog;

import com.ncu.sandy.blog.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserDao userDao;

    @Test
    void daoTest()
    {
        int id=userDao.queryUser("792901438@qq.com","123456");
        System.out.println("id="+id);
    }
}
