package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.CarOrThing;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.Order;
import com.mas.graduate.entity.User;
import com.mas.graduate.mapper.OrderMapper;
import com.mas.graduate.service.IOrderService;

@Service("orderServiceImpl")
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> getAllOrderByPage(Order order) {
		return orderMapper.getAllOrderByPage(order);
	}

	@Override
	public int getAllOrder(Order order) {
		return orderMapper.getAllOrder(order);
	}

	@Override
	public List<Order> getAllMyOrderByPage(Order order, User user) {
		return orderMapper.getAllMyOrderByPage(order,user);
	}

	@Override
	public int getAllMyOrder(Order order, User user) {
		return orderMapper.getAllMyOrder(order,user);
	}

	@Override
	public int deleteOrder(Order order) {
		return orderMapper.deleteOrder(order);
	}

	@Override
	public CarOrThing getCarOrThing(Order order) {
		return orderMapper.getCarOrThing(order);
	}

	@Override
	public int updateCar(int carId) {
		return orderMapper.updateCar(carId);
	}

	@Override
	public int updateThing(int thingId) {
		return orderMapper.updateThing(thingId);
	}

	@Override
	public List<LogCar> findCar(String carType, String companyName) {
		return orderMapper.findCar(carType,companyName);
	}

}
