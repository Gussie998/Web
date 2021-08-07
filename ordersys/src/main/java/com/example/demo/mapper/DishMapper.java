package com.example.demo.mapper;

import com.example.demo.model.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User:DELL
 * Date:2021-08-01
 * Time:13:53
 */

@Mapper
public interface DishMapper {

    public List<Dish> getList();

    public int del(int id);

    public int add(Dish dish);

}
