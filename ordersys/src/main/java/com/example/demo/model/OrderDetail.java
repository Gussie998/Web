package com.example.demo.model;

import lombok.Data;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:50
 */
@Data
public class OrderDetail {
    private int oid;
    private int did;
    private Dish dish;

}
