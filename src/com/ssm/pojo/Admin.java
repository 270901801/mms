package com.ssm.pojo;

public class Admin  {
	private int id;
    

	private String pwd;
    private String name;
    private Integer state;

    private Integer wrongtimes;

    private String lasttime;

    private int role;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getWrongtimes() {
		return wrongtimes;
	}

	public void setWrongtimes(Integer wrongtimes) {
		this.wrongtimes = wrongtimes;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [pwd=" + pwd + ", name=" + name + ", state=" + state + ", wrongtimes=" + wrongtimes
				+ ", lasttime=" + lasttime + ", role=" + role + "]";
	}
    
}