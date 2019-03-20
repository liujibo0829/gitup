package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;

import java.util.List;
public interface UserService {

    List allUser();
    User queryUser(String UserName);

//    public List<String> get queryUser(){
//            List<String> list= UserMapper.class
//        return list;
//    }
}
