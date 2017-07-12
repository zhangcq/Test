package com.mas.graduate.entity;

public class Order {

	private int orderId;
	private String orderNum;
	private String carOwner;
	private String carOwnerCompany;
	private String thingOwner;
	private String thingOwnerCompany;
	private String thingName;
	private String thingType;
	private String carType;
	private String releaseTime;
	private String orderTime;
	private String departure;
	private String destination;
	private String thingWeight;
	private int pageSize;
	private int pageNumber;
	public Order() {
		super();
	}
	public Order(int orderId,String orderNum, String carOwner, String carOwnerCompany,
			String thingOwner, String thingOwnerCompany, String thingName,
			String thingType, String carType, String releaseTime,
			String orderTime, String departure, String destination,
			String thingWeight,int pageSize,int pageNumber) {
		super();
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.carOwner = carOwner;
		this.carOwnerCompany = carOwnerCompany;
		this.thingOwner = thingOwner;
		this.thingOwnerCompany = thingOwnerCompany;
		this.thingName = thingName;
		this.thingType = thingType;
		this.carType = carType;
		this.releaseTime = releaseTime;
		this.orderTime = orderTime;
		this.departure = departure;
		this.destination = destination;
		this.thingWeight = thingWeight;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getCarOwnerCompany() {
		return carOwnerCompany;
	}
	public void setCarOwnerCompany(String carOwnerCompany) {
		this.carOwnerCompany = carOwnerCompany;
	}
	public String getThingOwner() {
		return thingOwner;
	}
	public void setThingOwner(String thingOwner) {
		this.thingOwner = thingOwner;
	}
	public String getThingOwnerCompany() {
		return thingOwnerCompany;
	}
	public void setThingOwnerCompany(String thingOwnerCompany) {
		this.thingOwnerCompany = thingOwnerCompany;
	}
	public String getThingName() {
		return thingName;
	}
	public void setThingName(String thingName) {
		this.thingName = thingName;
	}
	public String getThingType() {
		return thingType;
	}
	public void setThingType(String thingType) {
		this.thingType = thingType;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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
	public String getThingWeight() {
		return thingWeight;
	}
	public void setThingWeight(String thingWeight) {
		this.thingWeight = thingWeight;
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
