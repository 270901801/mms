package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Admin;

public interface AdminService {

	Admin selectByusernameAndPwd(Admin admin);
	int insert(Admin admin);
	Admin selectByusername(String name);
	void updateAdmin(Admin admin);
	List<Admin> selectAll();
	void deleteAdmin(String name);
	void deleteAdminById(int id);
	Admin selectById(int id);
}
