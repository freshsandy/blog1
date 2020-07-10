package com.ncu.sandy.blog.dao;

import com.ncu.sandy.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface UserDao {
    //如查找成功返回用户id 失败使用了ifnull返回0；
    int queryUser(String email,String password);
    User getUser(int id);//通过id去获得user的信息；
    int addUser(Map<String,Object> map);
}
