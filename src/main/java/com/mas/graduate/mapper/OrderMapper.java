package com.mas.graduate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mas.graduate.entity.CarOrThing;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.Order;
import com.mas.graduate.entity.User;

public interface OrderMapper {

	public List<Order> getAllOrderByPage(Order order);

	public int getAllOrder(Order order);

	public List<Order> getAllMyOrderByPage(@Param("order")Order order, @Param("user")User user);

	public int getAllMyOrder(@Param("order")Order order, @Param("user")User user);

	public int deleteOrder(Order order);

	public CarOrThing getCarOrThing(Order order);

	public int updateCar(int carId);

	public int updateThing(int thingId);

	public List<LogCar> findCar(@Param("carType")String carType,@Param("companyName") String companyName);

}
