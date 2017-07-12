package com.mas.graduate.entity;

public class Storage {
	private int storageId;
	private String storageNum;
	private String location;
	private String area;
	private String type;
	private int pageSize;
	private int pageNumber;
	public Storage(int storageId,String storageNum, String location, String area, String type, int pageSize, int pageNumber) {
		super();
		this.storageId = storageId;
		this.storageNum = storageNum;
		this.location = location;
		this.area = area;
		this.type = type;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}
	public Storage() {
		super();
	}
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public String getStorageNum() {
		return storageNum;
	}
	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
