package com.mas.graduate.entity;

public class Car {
	private int carid;
	private String departure;
	private String destination;
	private String cartype;
	private String weight;
	private String carvalue;
	private String releaseTime;
	private String releaser;
	private String phone;
	private String companyName;
	private int status;
	private int pageSize;
	private int pageNumber;
	
	public Car() {
		super();
	}
	
	public Car(int carid, String departure, String destination, String cartype,
			String weight, String carvalue, String releaseTime,
			String releaser, String phone, String companyName, int status,
			int pageSize, int pageNumber) {
		super();
		this.carid = carid;
		this.departure = departure;
		this.destination = destination;
		this.cartype = cartype;
		this.weight = weight;
		this.carvalue = carvalue;
		this.releaseTime = releaseTime;
		this.releaser = releaser;
		this.phone = phone;
		this.companyName = companyName;
		this.status = status;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCarvalue() {
		return carvalue;
	}
	public void setCarvalue(String carvalue) {
		this.carvalue = carvalue;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleaser() {
		return releaser;
	}
	public void setReleaser(String releaser) {
		this.releaser = releaser;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
