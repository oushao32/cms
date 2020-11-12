package com.java.service.impl;

import com.java.mapper.AdminMapper;
import com.java.pojo.Admin;
import com.java.service.AdminService;
import com.java.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper mapper;
    @Override
    public Result<Admin> loginByNameByPassword(@Param("name") String name,@Param("password")String password) {
        Admin admins = mapper.loginByNameByPassword(name, password);
        if (admins!=null){
            return Result.ok().setData(mapper.loginByNameByPassword(name, password));
        }else{
            //System.out.println(admins.getName()+"----"+admins.getPassword());
            return Result.error("用户名或密码不对").setData(Result.ERROR);
        }
    }

    @Override
    public Result<List<Admin>> getAdminAll() {
        if (mapper.getAdminAll()!=null){
            return Result.ok().setData(mapper.getAdminAll());
        }else{
            return Result.error("没找到数据").setData(Result.ERROR);
        }

    }

    @Override
    public int addAdmin(Admin admin) {
        return mapper.addAdmin(admin);
    }

    @Override
    public int editAdmin(Admin admin) {
        return mapper.editAdmin(admin);
    }
}
