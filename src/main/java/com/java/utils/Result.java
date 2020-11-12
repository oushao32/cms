package com.java.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Base64;

@Data
public class Result<T> implements Serializable {
    public static final int SUCCESS = 200;
    public static final int ERROR = -1;
    public static final int UNAUTHORIZED = 401;
    public static final int NO_AUTHORITY = 403;
    public static final int SERVER_EXPIRE = 777;
    private int status;
    private String info;
    private T data;

    public static Result ok() {
        return ok("成功");
    }

    public static Result ok(String info) {
        return of(info).setStatus(SUCCESS);
    }

    public static Result of(String info) {
        return of().setInfo(info);
    }

    public static Result error(String info) {
        return of(info).setStatus(ERROR);
    }

    public Result<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public Result<T> setInfo(String info) {
        this.info = info;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T> of() {
        return new Result();
    }

    public String encode() {
        String jsonStr = JSONObject.toJSONString(this);
        byte[] bytes = Rc4.encry_RC4_byte(jsonStr, "mr.k");
        return Base64.getEncoder().encodeToString(bytes);
    }
}
