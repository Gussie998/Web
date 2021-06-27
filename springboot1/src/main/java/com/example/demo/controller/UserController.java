package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User:DELL
 * Date:2021-06-27
 * Time:10:18
 *
 */



@Controller
@RequestMapping("/user")
@Slf4j

public class UserController {
    //创建一个当前类的日志对象
    private Logger logger =LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/index")
    @ResponseBody
    public String getIndex(String name){
        if(name==null || name.equals("")){
            logger.error("error");
        }
        logger.trace("111trace");
        logger.warn("222warn");
        logger.info("333info");
        logger.debug("444debug");
        return "null";
    }
}
