package com.ssm.entityTest;

import java.util.List;

public class Bigtype {
	private int id;
	private String name;
	private int state;
	private List<SmallType> smallTypes;
	
	public List<SmallType> getSmallTypes() {
		return smallTypes;
	}
	public void setSmallTypes(List<SmallType> smallTypes) {
		this.smallTypes = smallTypes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
