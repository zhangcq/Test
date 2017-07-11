package com.mas.graduate.entity;

public class User {
	private int userid;
	private String uname;
	private String utel;
	private String upwd;
	private String companyName;
	private String utype;
	private int pageSize;
	private int pageNumber;
	
	public User() {
		super();
	}

	public User(int userid, String uname, String utel, String upwd,
			String companyName, String utype) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.utel = utel;
		this.upwd = upwd;
		this.companyName = companyName;
		this.utype = utype;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}
