package com.ssm.entityTest;

import org.springframework.stereotype.Component;

@Component("admin")
public class Admin {
	private String name;
	private String pwd;
	private int state;
	private int id;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Admin() {
	}
	public Admin(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	
	public Admin(String name, String pwd, int state, int id) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.state = state;
		this.id = id;
	}
	
	public Admin(String name, int state, int id) {
		super();
		this.name = name;
		this.state = state;
		this.id = id;
	}
	public Admin(String name, String pwd, int state) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", pwd=" + pwd + ", state=" + state + ", id=" + id + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("�����ա���");
	}
	
	
}
