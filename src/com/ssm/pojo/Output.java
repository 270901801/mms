package com.ssm.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Output {
    private Integer oid;

    private String name;

    private Integer pcount;

    private BigDecimal price;
    
    private BigDecimal dprice;

    private String annt;

    private Date outputtime;

    
    
    public BigDecimal getDprice() {
		return dprice;
	}

	public void setDprice(BigDecimal dprice) {
		this.dprice = dprice;
	}

	public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public Date getOutputtime() {
        return outputtime;
    }

    public void setOutputtime(Date outputtime) {
        this.outputtime = outputtime;
    }

	@Override
	public String toString() {
		return "Output [oid=" + oid + ", name=" + name + ", pcount=" + pcount + ", price=" + price + ", annt=" + annt
				+ ", outputtime=" + outputtime + "]";
	}
    
    
}