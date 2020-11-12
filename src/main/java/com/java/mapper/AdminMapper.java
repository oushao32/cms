package com.java.mapper;

import com.java.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    Admin loginByNameByPassword(@Param("name")String name,@Param("password")String password);

    @Select("select id,name,password from admin")
    List<Admin> getAdminAll();

    int addAdmin(@Param("admin")Admin admin);

    int editAdmin(@Param("admin")Admin admin);
}
