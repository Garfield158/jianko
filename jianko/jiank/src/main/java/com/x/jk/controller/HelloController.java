package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    UserService userService;
    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
    @RequestMapping("/getUser")
    public Result showUser(){


        return  Result.bulid(userService.findAll());
    }
}
