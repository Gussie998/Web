package com.example.demo.mapper;

import com.example.demo.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User:DELL
 * Date:2021-08-07
 * Time:10:00
 */
@Mapper
public interface OrderInfoMapper {
    public  int add(OrderInfo orderInfo);

    public List<OrderInfo> getList(int uid);

    public List<OrderInfo> getAllList();

    public int up(int oid, int status);
}
