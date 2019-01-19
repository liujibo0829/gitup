package com.example.demo.controller;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class RoleController {
    @Autowired
    private UserRoleService userRoleService;
    /**
     * 显示所有用户信息
     * */
    @RequestMapping(value = {"/AllRole"})
    public String getAllUsers(HttpServletRequest request){
        List list =  userRoleService.allRole();
        request.setAttribute("list", list);
        return "view/system/roleinfo/role_list";

    }
}
