package com.example.StudentManagement.service;

import com.example.StudentManagement.dao.UserRepository;
import com.example.StudentManagement.entity.Params;
import com.example.StudentManagement.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userDao;

    public List<User> findAllUser(){return userDao.selectAll();}

    public List<User> findBySearch(Params param) {
        return userDao.findBySearch(param);
    }

    public void addUser(User user){
        //1.进行重复性判断
        User testUser = userDao.findById(user.getUserID());
        if (user != null){
            // 已经存在该用户，提示前台不允许新增
        }

        //2.初始化用户密码
        if (user.getPasswd() == null){
            user.setPasswd("123456");
        }
        userDao.insertSelective(user);
    }

    public User login(User user) {
        // 1.进行非空判断

        // 2.从数据里根据用户名和密码，查询对应的用户信息
        // 3.如果查出来没有，输入的用户名和密码有误，提示用户不允许登录

        return null;
    }


    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    public void delete(String id) {
        userDao.deleteByPrimaryKey(id);
    }
}
