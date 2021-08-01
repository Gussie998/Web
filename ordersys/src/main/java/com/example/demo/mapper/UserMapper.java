package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:57
 */
@Mapper
public interface UserMapper {


    public int register(UserInfo userInfo);


    public  List<UserInfo> getUserList();

    public UserInfo login(UserInfo userInfo);
}