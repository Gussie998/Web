package com.example.demo.dao;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User:DELL
 * Date:2021-07-04
 * Time:17:43
 */
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void addUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("u");
        userInfo.setPassword("p");

        int result = userInfoMapper.addUser(userInfo);
        System.out.println(result);

    }
}