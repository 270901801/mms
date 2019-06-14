package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.AdminMapper;
import com.ssm.pojo.Admin;



@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public Admin selectByusernameAndPwd(Admin admin){
		return adminMapper.selectByusernameAndPwd(admin);
	}
	@Override
	public int insert(Admin admin) {
		
		return adminMapper.insert(admin);
	}
	@Override
	public Admin selectByusername(String name) {
		return adminMapper.selectByusername(name);
	}
	@Override
	public void updateAdmin(Admin admin) {
		adminMapper.updateAdmin(admin);
	}
	@Override
	public List<Admin> selectAll() {
		return adminMapper.selectAll();
	}
	@Override
	public void deleteAdmin(String name) {
		adminMapper.deleteByName(name);
		
	}
	@Override
	public void deleteAdminById(int id) {
		adminMapper.deleteById(id);
		
	}
	@Override
	public Admin selectById(int id) {
		// TODO Auto-generated method stub
		return adminMapper.selectById(id);
	}
	
}
