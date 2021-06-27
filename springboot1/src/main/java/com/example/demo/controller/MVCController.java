package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User:DELL
 * Date:2021-06-27
 * Time:11:30
 */

@Controller
@RequestMapping("/mvc")
public class MVCController {

    @ResponseBody//返回接口信息而非视图，可以修饰方法和类
    @RequestMapping("/index7")//jackson
    public User getIndex7(){
        User user = new User();
        user.setPassword("password");
        user.setUsername("username");
        return user;
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "/index.html";//返回一个视图
    }
}
