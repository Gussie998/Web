package com.example.demo.controller;

import com.example.demo.mapper.DishMapper;
import com.example.demo.model.Dish;
import com.example.demo.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * User:DELL
 * Date:2021-08-01
 * Time:13:12
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Resource
    private DishMapper dishMapper;

    @RequestMapping("/list")
    public ResponseBody<List<Dish>>getList(){
        List<Dish> data =dishMapper.getList();
        return new ResponseBody<>(0,"",data);

    }
}
