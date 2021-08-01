package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User:DELL
 * Date:2021-07-08
 * Time:20:30
 */
@Mapper
public  interface UserMapper {
    public  int addUser(User user);
}
