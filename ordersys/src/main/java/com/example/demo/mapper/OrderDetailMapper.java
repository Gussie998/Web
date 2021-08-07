package com.example.demo.mapper;

import com.example.demo.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User:DELL
 * Date:2021-08-07
 * Time:10:08
 */
@Mapper
public interface OrderDetailMapper {
    public int add(int oid,String[] dids);

    public List<OrderDetail> getList(int oid);
}
