package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;
public interface UserService {

    List allUser();
    User queryUser(String UserName);
}