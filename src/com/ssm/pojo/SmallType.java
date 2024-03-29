package com.ssm.pojo;

public class SmallType {
    private Integer id;

    private String name;

    private Integer bid;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "SmallType [id=" + id + ", name=" + name + ", bid=" + bid + ", state=" + state + "]";
	}
    
    
}