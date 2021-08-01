package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:49
 */
@Data
public class Dish {
    private int id;
    private String name;
    private BigDecimal price;
}
