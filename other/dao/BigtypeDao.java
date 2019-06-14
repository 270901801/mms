package com.ssm.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ssm.entityTest.Bigtype;

public class BigtypeDao extends SqlSessionDaoSupport{
private Bigtype Bigtype;
	
	public Bigtype getBigtype() {
		return Bigtype;
	}

	public void setBigtype(Bigtype Bigtype) {
		this.Bigtype = Bigtype;
	}

	//��
	public void insert(Bigtype Bigtype){
		this.getSqlSession().insert("com.hzit.ssm.BigtypeMapper.insertBigtype", Bigtype);
	}
	//ɾ
	public void deleteById(int id) {
		this.getSqlSession().delete("com.hzit.ssm.BigtypeMapper.deleteBigtype", id);
	}
	//��
	public void update(Bigtype Bigtype) {
		this.getSqlSession().update("com.hzit.ssm.BigtypeMapper.updateByPrimaryKey", Bigtype);
	}
	//��
	public List<Bigtype> getAll(){
		return this.getSqlSession().selectList("com.hzit.ssm.BigtypeMapper.findAll");
	}
	public Bigtype getBigtypeById(int id) {
		return this.getSqlSession().selectOne("testMapper.BigtypeMapper.selectByPrimaryKey",id);
	}
	public Bigtype getBigtypeByName(String name) {
		return this.getSqlSession().selectOne("com.hzit.ssm.BigtypeMapper.findByName",name);
	}
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BigtypeService service=(BigtypeService) context.getBean("as");
//		service.insert(Bigtype);
		BigtypeDao ad=new BigtypeDao();
		System.out.println(ad.getBigtypeById(4));
	}
}
