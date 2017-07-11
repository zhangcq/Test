package com.mas.graduate.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.mas.graduate.entity.CarOrThing;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.Order;
import com.mas.graduate.entity.User;
import com.mas.graduate.service.IOrderService;

@Controller
@RequestMapping("/order")
@SessionAttributes("user")
public class OrderHandler {
	@Autowired
	private IOrderService service;
	
	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
	public String getAllOrder(String departure,String destination,String orderNum,int pageNumber,int pageSize,PrintWriter out) {
		Order order = new Order();
		try {
			if(departure != null){
				order.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				order.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(orderNum != null){
				order.setOrderNum(URLDecoder.decode(orderNum,"utf-8"));
			}
			order.setPageNumber(pageNumber);
			order.setPageSize(pageSize);
			List<Order> orders = service.getAllOrderByPage(order);
			Gson gson = new Gson();
			String userStr = gson.toJson(orders);
			String json = "{\"total\":" + service.getAllOrder(order) + ",\"rows\":"
					+ userStr + "}";
			out.print(json);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "car";
	}
	
	@RequestMapping(value = "/getAllMyOrder", method = RequestMethod.GET)
	public String getAllMyOrder(String departure,String destination,String orderNum,int pageNumber,int pageSize,PrintWriter out,User user) {
		Order order = new Order();
		try {
			if(departure != null){
				order.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				order.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(orderNum != null){
				order.setOrderNum(URLDecoder.decode(orderNum,"utf-8"));
			}
			order.setPageNumber(pageNumber);
			order.setPageSize(pageSize);
			List<Order> orders = service.getAllMyOrderByPage(order,user);
			Gson gson = new Gson();
			String userStr = gson.toJson(orders);
			String json = "{\"total\":" + service.getAllMyOrder(order,user) + ",\"rows\":"
					+ userStr + "}";
			out.print(json);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mycar";
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	public void deleteOrder(Order order,PrintWriter out) {
		int result = service.deleteOrder(order);
		CarOrThing or = service.getCarOrThing(order);
		result = service.updateCar(or.getCarId());
		result = service.updateThing(or.getThingId());
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/findCar", method = RequestMethod.POST)
	public void findCar(String carType,String companyName,PrintWriter out) {
		String str="";
		List<LogCar> list = service.findCar(carType,companyName);
		if(list.size()>0){
			for(LogCar car :list){
				str+="<option>"+car.getCarNum()+"</option>";
			}
		}
		out.print(str);
		out.flush();
		out.close();
	}
	
}