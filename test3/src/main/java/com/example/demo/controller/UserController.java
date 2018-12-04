package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 显示所有用户信息
     * */
    @RequestMapping(value = {"/findAll"})
    public String getAllUsers(HttpServletRequest request){
        List list =  userService.allUser();
        request.setAttribute("list", list);
        return "view/system/userinfo/user_list";

    }

    /**
     * 根据用户姓名查询用户信息
     * */
//    @RequestMapping(value = {"/queryUser"})
//    public String queryUser(String UserName, User user){
//         user = userService.queryUser(UserName);
//        request.setAttribute("list", user);
//        return "view/system/userinfo/user_list";
//
//    }

}
