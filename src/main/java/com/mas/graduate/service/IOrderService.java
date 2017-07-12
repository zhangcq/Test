package com.mas.graduate.service;

import java.util.List;

import com.mas.graduate.entity.CarOrThing;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.Order;
import com.mas.graduate.entity.User;

public interface IOrderService {

	List<Order> getAllOrderByPage(Order order);

	int getAllOrder(Order order);

	List<Order> getAllMyOrderByPage(Order order, User user);

	int getAllMyOrder(Order order, User user);

	int deleteOrder(Order order);

	CarOrThing getCarOrThing(Order order);

	int updateCar(int carId);

	int updateThing(int thingId);

	List<LogCar> findCar(String carType, String companyName);

}
