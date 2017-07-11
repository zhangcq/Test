package com.mas.graduate.entity;

public class Dispatch {

	private String dispatchRecordId;
	private String tradeRecordId;
	private String thingOwner;
	private String thingType;
	private String thingName;
	private String carOwner;
	private String companyName;
	private String carType;
	private String carNum;
	private String sendTime;
	private String departure;
	private String destination;
	public Dispatch(String dispatchRecordId, String tradeRecordId,
			String thingOwner, String thingType, String thingName,
			String carOwner, String companyName, String carType, String carNum,
			String sendTime,String departure,String destination) {
		super();
		this.dispatchRecordId = dispatchRecordId;
		this.tradeRecordId = tradeRecordId;
		this.thingOwner = thingOwner;
		this.thingType = thingType;
		this.thingName = thingName;
		this.carOwner = carOwner;
		this.companyName = companyName;
		this.carType = carType;
		this.carNum = carNum;
		this.sendTime = sendTime;
		this.departure = departure;
		this.destination = destination;
	}
	public Dispatch() {
		super();
	}
	public String getDispatchRecordId() {
		return dispatchRecordId;
	}
	public void setDispatchRecordId(String dispatchRecordId) {
		this.dispatchRecordId = dispatchRecordId;
	}
	public String getTradeRecordId() {
		return tradeRecordId;
	}
	public void setTradeRecordId(String tradeRecordId) {
		this.tradeRecordId = tradeRecordId;
	}
	public String getThingOwner() {
		return thingOwner;
	}
	public void setThingOwner(String thingOwner) {
		this.thingOwner = thingOwner;
	}
	public String getThingType() {
		return thingType;
	}
	public void setThingType(String thingType) {
		this.thingType = thingType;
	}
	public String getThingName() {
		return thingName;
	}
	public void setThingName(String thingName) {
		this.thingName = thingName;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
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
}
