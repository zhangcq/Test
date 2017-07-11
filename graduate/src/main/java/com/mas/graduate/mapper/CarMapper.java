package com.mas.graduate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mas.graduate.entity.Car;
import com.mas.graduate.entity.Dispatch;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.User;

public interface CarMapper {

	List<Car> getAllCarByPage(Car car);

	int getAllCar(Car car);

	List<Car> getAllMyCarByPage(@Param("car")Car car, @Param("user")User user);

	int getAllMyCar(@Param("car")Car car, @Param("user")User user);

	int addCar(@Param("car")Car car, @Param("user")User user);

	int editCar(Car car);

	int deleteCar(Car car);

	int addTradeRecord(@Param("carid")int carid, @Param("thingid")int thingid,@Param("reportNum")String reportNum, @Param("owner") User owner, @Param("user")User user);

	int updateCarStatus(int carid);

	int updateThingStatus(int thingid);

	User getUserByCarId(int carid);

	List<LogCar> getAllLogCarByPage(LogCar car);

	int getAllLogCar(LogCar car);

	int addLogCar(@Param("car")LogCar car, @Param("user")User user);

	int editLogCar(LogCar car);

	int deleteLogCar(LogCar car);

	int tradeCar(@Param("orderId")int orderId, @Param("recordNum")String recordNum,@Param("carNum")String carNum, @Param("user") User user);

	int updateTradeRecord(int orderId);

	Dispatch getDispatch(int orderId);

}
