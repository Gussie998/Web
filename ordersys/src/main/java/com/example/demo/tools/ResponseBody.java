package com.example.demo.tools;

import lombok.Data;

/**
 * User:DELL
 * Date:2021-07-31
 * Time:14:53
 */

@Data
public class ResponseBody<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseBody(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
