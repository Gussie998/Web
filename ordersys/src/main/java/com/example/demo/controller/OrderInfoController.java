package com.example.demo.controller;

import com.example.demo.config.AppFinal;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.mapper.OrderInfoMapper;
import com.example.demo.model.OrderInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.tools.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User:DELL
 * Date:2021-08-07
 * Time:9:53
 */

@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @RequestMapping("/add")
    public ResponseBody<Integer> add(String dids, HttpServletRequest request){
        int data = 0;
        //添加订单信息 返回订单id
        HttpSession session = request.getSession(false);
        if(session!=null &&session.getAttribute(AppFinal.USERINFO_SESSION_KEY)!=null){
            int uid = ((UserInfo)session.getAttribute(AppFinal.USERINFO_SESSION_KEY)).getId();
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setUid(uid);

            int result = orderInfoMapper.add(orderInfo);
            if(result>0){
                //添加定案详情
                data = orderDetailMapper.add(orderInfo.getId(),dids.split(","));
            }
        }

        return new ResponseBody<>(0,"",data);

    }

    @RequestMapping("/list")
    public ResponseBody<List<OrderInfo>> getList( HttpServletRequest request){
        List<OrderInfo> list = null;
        HttpSession session = request.getSession(false);
        if(session!=null &&session.getAttribute(AppFinal.USERINFO_SESSION_KEY)!=null) {
            int uid = ((UserInfo) session.getAttribute(AppFinal.USERINFO_SESSION_KEY)).getId();
            list=orderInfoMapper.getList(uid);
        }
        return new ResponseBody<>(0,"",list);
    }

    @RequestMapping("/alllist")
    public ResponseBody<List<OrderInfo>> getAllList(HttpServletRequest request){
        List<OrderInfo> list = orderInfoMapper.getAllList();
        return new ResponseBody<>(0,"",list);
    }

    @RequestMapping("/up")
    public ResponseBody<Integer> up(int oid,int status){
        int data = 0;
        data = orderInfoMapper.up(oid,status);
        return new ResponseBody<>(0,"",data);
    }
}
