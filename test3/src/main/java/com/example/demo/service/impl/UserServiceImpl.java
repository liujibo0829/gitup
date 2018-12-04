package com.example.demo.service.impl;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;//这里可能会报错，但是并不会影响

    @Override
    public List allUser(){
        return  userDao.allUser();
    }
    public User queryUser(String UserName){
        return  userDao.queryUser(UserName);
    }
}
