package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-06-27
 * Time:15:32
 */


@RestController
@RequestMapping("/method")
public class MethodController {

    @GetMapping("/people/{pid}/animal/{aid}")
    //获取url里面的动态参数
    public String method1(@PathVariable String pid ,@PathVariable("aid") String animalId){
        return "用户id:"+pid+"动物id"+animalId;
    }


    @RequestMapping("/login")
    public Object login(User user, HttpServletRequest request){
        // 返回的对象
        HashMap<String,Object> map = new HashMap<>();
        int status = -1; // 非正常返回
        String msg = "未知错误";
        String data  = "登录失败";
        if(user!=null &&
                user.getUsername().equals("root") &&
                user.getPassword().equalsIgnoreCase("root")){
            // 登录信息存储到 Session
            HttpSession session = request.getSession();
            session.setAttribute("userinfo",user);
            status = 0;
            msg = "";
            data = "登录成功";
        }else{
            status = 0;
            msg = "用户名错误";
            data = "登录失败";
        }
        map.put("status",status);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }

}
