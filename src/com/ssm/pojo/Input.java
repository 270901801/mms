package com.ssm.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Input {
    private Integer id;

    private String name;

    private Integer pcount;

    private BigDecimal dprice;

    private BigDecimal price;

    private String annt;

    private String pname;

    private Date inputtime;

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

    public Integer getPcount() {
        return pcount;
    }

    public void setPcount(Integer pcount) {
        this.pcount = pcount;
    }

    public BigDecimal getDprice() {
        return dprice;
    }

    public void setDprice(BigDecimal dprice) {
        this.dprice = dprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAnnt() {
        return annt;
    }

    public void setAnnt(String annt) {
        this.annt = annt == null ? null : annt.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

	@Override
	public String toString() {
		return "Input [id=" + id + ", name=" + name + ", pcount=" + pcount + ", dprice=" + dprice + ", price=" + price
				+ ", annt=" + annt + ", pname=" + pname + ", inputtime=" + inputtime + "]";
	}
    
}