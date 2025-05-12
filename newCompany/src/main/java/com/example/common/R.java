package com.example.common;

import lombok.Data;
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(T data) {
        R<T> result = new R<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> R<T> error(String msg) {
        R<T> result = new R<>();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}