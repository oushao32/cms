package com.java.controller;

import com.java.pojo.Admin;
import com.java.service.impl.AdminServiceImpl;
import com.java.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    @Autowired
    private AdminServiceImpl service;

    @PostMapping("/login")
    public Result loginByNameByPassword(@RequestBody Admin admin){
        return Result.of().setData(service.loginByNameByPassword(admin.getName(),admin.getPassword()));
    }
}
