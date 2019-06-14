package com.ssm.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.entityTest.Admin;
import com.ssm.service.AdminService;


public class TestMybatis {
	public static void main(String[] args) throws IOException {
		//����mybatis
		String resource = "mybatis-config.xml";
		//��ȡMyBatis�����ļ��Լ�����ӳ���ļ�
		InputStream is = Resources.getResourceAsStream(resource);
		//����Ự����
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//�����Ự����
		SqlSession session = sessionFactory.openSession();
		System.out.println(session);
//		System.out.println(session);
//		List<Admin> list=session.selectList("com.hzit.ssm.AdminMapper.findAll");
//		System.out.println(list);
		Admin admin =session.selectOne("com.hzit.ssm.AdminMapper.findById", 6);
		
		System.out.println(admin);
//		List<Admin> list2=session.selectList("com.hzit.ssm.AdminMapper.findAllByName","��");
//		System.out.println(list2);
		//��ҳ��Щһֱ����
		int pageSize=3;//ÿҳ��ʾ�ļ�¼��
		int currentPage=1;//��ǰҳ
		
		//��ҳ��ѯ
		List<Admin> list3=session.selectList("com.hzit.ssm.AdminMapper.findAll",null,new RowBounds((currentPage-1)*pageSize,pageSize));
		for(Admin admin1:list3) {
//			System.out.println(admin1);
		}
		
		admin =new Admin("hsc",1,11);
//		session.update("com.hzit.ssm.AdminMapper.updateAdmin",admin);
		session.insert("com.hzit.ssm.AdminMapper.insertAdmin", admin);
		//�޸ĵ�����
		//��Ϊ��������
		//1�Ȱ����ݲ�ѯ����
		//2�ѿ����޸ĵ��޸�
		session.commit();
//		System.out.println(state);
		System.out.println("sc");
		
		session.close();
	}
}
