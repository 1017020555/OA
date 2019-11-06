package com.offcn.auth.controller;

import com.offcn.auth.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/add")
    public String add(Role role){

        System.out.println(role);
        return "role";
    }
}
