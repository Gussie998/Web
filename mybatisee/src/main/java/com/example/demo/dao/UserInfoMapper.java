package com.example.demo.dao;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * User:DELL
 * Date:2021-07-04
 * Time:17:27
 */

@Mapper
public interface UserInfoMapper {
    public int addUser(UserInfo userInfo);
}
