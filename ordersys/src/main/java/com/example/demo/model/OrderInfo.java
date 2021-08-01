package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:47
 */
@Data
public class OrderInfo {
    private int id;
    private int uid;
    private Date createtime;
    private int status;

}
