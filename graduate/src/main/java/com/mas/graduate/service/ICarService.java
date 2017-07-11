package com.mas.graduate.service;

import java.util.List;

import com.mas.graduate.entity.Car;
import com.mas.graduate.entity.Dispatch;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.User;

public interface ICarService {

	public List<Car> getAllCarByPage(Car car);

	public int getAllCar(Car car);

	public List<Car> getAllMyCarByPage(Car car, User user);

	int getAllMyCar(Car car, User user);

	public int addCar(Car car, User user);

	public int editCar(Car car);

	public int deleteCar(Car car);

	public int addTradeRecord(int carid, int thingid, String reportNum, User owner, User user);

	public int updateCarStatus(int carid);

	public int updateThingStatus(int thingid);

	public User getUserByCarId(int carid);

	public List<LogCar> getAllLogCarByPage(LogCar car);

	public int getAllLogCar(LogCar car);

	public int addLogCar(LogCar car, User user);

	public int editLogCar(LogCar car);

	public int deleteLogCar(LogCar car);

	public int tradeCar(int orderId, String recordNum, String carNum, User user);

	public int updateTradeRecord(int orderId);

	public Dispatch getDispatch(int orderId);
}
