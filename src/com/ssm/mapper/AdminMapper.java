package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.Admin;
import com.ssm.pojo.AdminExample;

public interface AdminMapper {
    long count();

    int deleteByName(String name);

    int insert(Admin admin);

    List<Admin> selectAll();

    int updateAdmin(Admin admin);

	Admin selectByusernameAndPwd(Admin admin);

	Admin selectByusername(String name);

	void deleteById(int id);

	Admin selectById(int id);
}