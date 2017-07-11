package com.mas.graduate.entity;

public class LogCar {
	private int carId;
	private String carNum;
	private String carType;
	private String companyName;
	private String createTime;
	private String creater;
	private int status;
	private int pageSize;
	private int pageNumber;
	
	public LogCar() {
		super();
	}

	public LogCar(int carId, String carNum, String carType, String companyName,
			String createTime, String creater, int status, int pageSize,
			int pageNumber) {
		super();
		this.carId = carId;
		this.carNum = carNum;
		this.carType = carType;
		this.companyName = companyName;
		this.createTime = createTime;
		this.creater = creater;
		this.status = status;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
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
