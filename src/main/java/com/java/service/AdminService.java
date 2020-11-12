package com.java.service;

import com.java.pojo.Admin;
import com.java.utils.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService{
    Result<Admin> loginByNameByPassword(@Param("name")String name, @Param("password")String password);

    Result<List<Admin>> getAdminAll();

    int addAdmin(@Param("admin")Admin admin);

    int editAdmin(@Param("admin")Admin admin);
}
