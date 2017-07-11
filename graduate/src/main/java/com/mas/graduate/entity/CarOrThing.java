package com.mas.graduate.entity;

public class CarOrThing {

	private int carId;
	private int thingId;
	public CarOrThing() {
		super();
	}
	
	public CarOrThing(int carId, int thingId) {
		super();
		this.carId = carId;
		this.thingId = thingId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getThingId() {
		return thingId;
	}

	public void setThingId(int thingId) {
		this.thingId = thingId;
	}
	
	
}
