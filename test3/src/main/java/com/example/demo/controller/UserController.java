package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
/**
 * 使用@RestController注解相当于@Controller+@ResponseBody两个注解的结合，返回json数据就不需要后者的注释了，但是不能返回jsp和html界面
 * */
//@RestController
public class UserController {
    /**
     * 优先加载被@Autowired注解过的代码块
     * */
    @Autowired
    private UserService userService;

    /**
     * 显示所有用户信息
     * */
    @RequestMapping(value = {"/queryUser"})
    public String getAllUsers(HttpServletRequest request){
        List list =  userService.allUser();
        request.setAttribute("list", list);
        return "view/system/userinfo/user_list";

    }


    /**
     * 后台将java对象转化成json格式输出
     * */
    @GetMapping("/studentJson")
    @ResponseBody
    public List getUserJson(){
        String userName= "张三";
        User user= userService.queryUser(userName);
            List<User> users= new ArrayList<>();
          List list =  userService.allUser();
            users.add(user);
        return list;
    }

    @RequestMapping(value = {"/test"})
    @ResponseBody
    public void diaoyong(){
        getUserJson();
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
