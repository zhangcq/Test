package com.mas.graduate.entity;

public class Thing {
	private int thingid;
	private String departure;
	private String destination;
	private String thingName;
	private String thingtype;
	private String weight;
	private String releaseTimeBegin;
	private String releaseTimeEnd;
	private String releaseTime;
	private String releaser;
	private String phone;
	private String companyName;
	private int status;
	private int pageSize;
	private int pageNumber;
	
	public Thing() {
		super();
	}

	public Thing(int thingid, String departure, String destination,
			String thingName, String thingtype, String weight,
			String releaseTimeBegin, String releaseTimeEnd, String releaser,
			String phone, String companyName, int status, int pageSize,
			int pageNumber) {
		super();
		this.thingid = thingid;
		this.departure = departure;
		this.destination = destination;
		this.thingName = thingName;
		this.thingtype = thingtype;
		this.weight = weight;
		this.releaseTimeBegin = releaseTimeBegin;
		this.releaseTimeEnd = releaseTimeEnd;
		this.releaser = releaser;
		this.phone = phone;
		this.companyName = companyName;
		this.status = status;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}



	public int getThingid() {
		return thingid;
	}

	public void setThingid(int thingid) {
		this.thingid = thingid;
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

	public String getThingName() {
		return thingName;
	}

	public void setThingName(String thingName) {
		this.thingName = thingName;
	}

	public String getThingtype() {
		return thingtype;
	}

	public void setThingtype(String thingtype) {
		this.thingtype = thingtype;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getReleaseTimeBegin() {
		return releaseTimeBegin;
	}

	public void setReleaseTimeBegin(String releaseTimeBegin) {
		this.releaseTimeBegin = releaseTimeBegin;
	}

	public String getReleaseTimeEnd() {
		return releaseTimeEnd;
	}

	public void setReleaseTimeEnd(String releaseTimeEnd) {
		this.releaseTimeEnd = releaseTimeEnd;
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

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	
}
