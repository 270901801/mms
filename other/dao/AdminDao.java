package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsc.ssm.mapper.AdminMapper;
import com.hsc.ssm.pojo.Admin;


public class AdminDao extends SqlSessionDaoSupport {

	
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	//增
	public void insert(Admin admin){
		this.getSqlSession().insert("com.hzit.ssm.AdminMapper.insertAdmin", admin);
	}
	//删
	public void deleteById(int id) {
		this.getSqlSession().delete("com.hzit.ssm.AdminMapper.deleteAdmin", id);
	}
	//改
	public void update(Admin admin) {
		this.getSqlSession().update("com.hzit.ssm.AdminMapper.updateAdmin", admin);
	}
	//查
	public List<Admin> getAll(){
		return this.getSqlSession().selectList("com.hzit.ssm.AdminMapper.findAll");
	}
	public Admin getAdminById(int id) {
		return this.getSqlSession().selectOne("com.hzit.ssm.AdminMapper.findById",id);
	}
	public Admin getAdminByName(String name) {
		return this.getSqlSession().selectOne("com.hzit.ssm.AdminMapper.findByName",name);
	}
	
	public static void main(String[] args) {
		AdminMapper am = null;
		System.out.println(am.selectByPrimaryKey(2));
	}
}
