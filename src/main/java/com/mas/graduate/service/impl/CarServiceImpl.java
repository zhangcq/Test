package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.Car;
import com.mas.graduate.entity.Dispatch;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.User;
import com.mas.graduate.mapper.CarMapper;
import com.mas.graduate.service.ICarService;

@Service("carServiceImpl")
public class CarServiceImpl implements ICarService{

	@Autowired
	private CarMapper carMapper;

	@Override
	public List<Car> getAllCarByPage(Car car) {
		return carMapper.getAllCarByPage(car);
	}

	@Override
	public int getAllCar(Car car) {
		return carMapper.getAllCar(car);
	}

	@Override
	public List<Car> getAllMyCarByPage(Car car, User user) {
		return carMapper.getAllMyCarByPage(car,user);
	}
	
	@Override
	public int getAllMyCar(Car car, User user) {
		return carMapper.getAllMyCar(car,user);
	}

	@Override
	public int addCar(Car car,User user) {
		return carMapper.addCar(car,user);
	}

	@Override
	public int editCar(Car car) {
		return carMapper.editCar(car);
	}

	@Override
	public int deleteCar(Car car) {
		return carMapper.deleteCar(car);
	}

	@Override
	public int addTradeRecord(int carid, int thingid,String reportNum, User owner, User user) {
		return carMapper.addTradeRecord(carid,thingid,reportNum,owner,user);
	}


	@Override
	public int updateCarStatus(int carid) {
		return carMapper.updateCarStatus(carid);
	}

	@Override
	public int updateThingStatus(int thingid) {
		return carMapper.updateThingStatus(thingid);
	}

	@Override
	public User getUserByCarId(int carid) {
		return carMapper.getUserByCarId(carid);
	}

	@Override
	public List<LogCar> getAllLogCarByPage(LogCar car) {
		return carMapper.getAllLogCarByPage(car);
	}

	@Override
	public int getAllLogCar(LogCar car) {
		return carMapper.getAllLogCar(car);
	}

	@Override
	public int addLogCar(LogCar car, User user) {
		return carMapper.addLogCar(car,user);
	}

	@Override
	public int editLogCar(LogCar car) {
		return carMapper.editLogCar(car);
	}

	@Override
	public int deleteLogCar(LogCar car) {
		return carMapper.deleteLogCar(car);
	}

	@Override
	public int tradeCar(int orderId, String recordNum,String carNum, User user) {
		return carMapper.tradeCar(orderId,recordNum,carNum,user);
	}

	@Override
	public int updateTradeRecord(int orderId) {
		return carMapper.updateTradeRecord(orderId);
	}

	@Override
	public Dispatch getDispatch(int orderId) {
		return carMapper.getDispatch(orderId);
	}
}
