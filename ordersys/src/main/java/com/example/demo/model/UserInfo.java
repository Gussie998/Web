package com.example.demo.model;

import lombok.Data;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:46
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private int isadmin;
}
