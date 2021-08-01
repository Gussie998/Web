package com.example.usermanager.tools;

import lombok.Data;

/**
 * User:DELL
 * Date:2021-07-24
 * Time:9:21
 */

@Data

public class ResponseBody<T> {
    private int status;
    private String message;
    private T data;

    public ResponseBody(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
