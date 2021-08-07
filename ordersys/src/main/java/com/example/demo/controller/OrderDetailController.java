package com.example.demo.controller;

import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.model.OrderDetail;
import com.example.demo.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * User:DELL
 * Date:2021-08-07
 * Time:11:48
 */
@RestController
@RequestMapping("/detail")
public class OrderDetailController {

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @RequestMapping("/list")
    public ResponseBody<List<OrderDetail>> getList(int oid){
        List<OrderDetail> list = orderDetailMapper.getList(oid);
        return new ResponseBody<>(0,"",list);

    }
}
