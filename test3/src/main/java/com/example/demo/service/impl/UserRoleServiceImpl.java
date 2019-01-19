package com.example.demo.service.impl;

import com.example.demo.dao.UserRoleMapper;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleDao;

    @Override
    public List allRole(){
        return userRoleDao.allRole();
    }
}
