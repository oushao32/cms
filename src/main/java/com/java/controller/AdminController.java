package com.java.controller;

import com.java.pojo.Admin;
import com.java.service.impl.AdminServiceImpl;
import com.java.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl service;
    @GetMapping("/getAllAdmin")
    public Result<List<Admin>> getAllAdmin(){
        return Result.ok().setData(service.getAdminAll());
    }
    @PostMapping(value = "/addAdmin")
    public int addAdmin(Admin admin){
        if (service.addAdmin(admin)>0){
            return 1;
        }else {
            return 0;
        }
    }
    @PostMapping(value = "/editAdmin")
    public int editAdmin(Admin admin){
        if (service.editAdmin(admin)>0){
            return 1;
        }else {
            return 0;
        }
    }
}
