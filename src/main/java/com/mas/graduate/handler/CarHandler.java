package com.mas.graduate.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.mas.graduate.entity.Car;
import com.mas.graduate.entity.Dispatch;
import com.mas.graduate.entity.LogCar;
import com.mas.graduate.entity.User;
import com.mas.graduate.service.ICarService;

@Controller
@RequestMapping("/car")
@SessionAttributes("user")
public class CarHandler {
	@Autowired
	private ICarService service;
	
	@RequestMapping(value = "/getAllCar", method = RequestMethod.GET)
	public String getAllUser(String departure,String destination,String cartype,int pageNumber,int pageSize,PrintWriter out) {
		Car car = new Car();
		try {
			if(departure != null){
				car.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				car.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(cartype != null){
				car.setCartype(URLDecoder.decode(cartype,"utf-8"));
			}
			car.setPageNumber(pageNumber);
			car.setPageSize(pageSize);
			List<Car> cars = service.getAllCarByPage(car);
			Gson gson = new Gson();
			String userStr = gson.toJson(cars);
			String json = "{\"total\":" + service.getAllCar(car) + ",\"rows\":"
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
	
	@RequestMapping(value = "/getAllLogCar", method = RequestMethod.GET)
	public String getAllLogCar(String carNum,String carType,String companyName,int pageNumber,int pageSize,PrintWriter out) {
		LogCar car = new LogCar();
		try {
			if(carNum != null){
				car.setCarNum(URLDecoder.decode(carNum,"utf-8"));
			}
			if(carType != null){
				car.setCarType(URLDecoder.decode(carType,"utf-8"));
			}
			if(companyName != null){
				car.setCompanyName(URLDecoder.decode(companyName,"utf-8"));
			}
			car.setPageNumber(pageNumber);
			car.setPageSize(pageSize);
			List<LogCar> cars = service.getAllLogCarByPage(car);
			Gson gson = new Gson();
			String userStr = gson.toJson(cars);
			String json = "{\"total\":" + service.getAllLogCar(car) + ",\"rows\":"
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
	
	@RequestMapping(value = "/getAllMyCar", method = RequestMethod.GET)
	public String getAllMyCar(String departure,String destination,String cartype,int pageNumber,int pageSize,PrintWriter out,User user) {
		Car car = new Car();
		try {
			if(departure != null){
				car.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				car.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(cartype != null){
				car.setCartype(URLDecoder.decode(cartype,"utf-8"));
			}
			car.setPageNumber(pageNumber);
			car.setPageSize(pageSize);
			List<Car> cars = service.getAllMyCarByPage(car,user);
			Gson gson = new Gson();
			String userStr = gson.toJson(cars);
			String json = "{\"total\":" + service.getAllMyCar(car,user) + ",\"rows\":"
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
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public void addCar(Car car,User user,PrintWriter out) {
		int result = service.addCar(car,user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/addLogCar", method = RequestMethod.POST)
	public void addLogCar(LogCar car,User user,PrintWriter out) {
		int result = service.addLogCar(car,user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editCar", method = RequestMethod.POST)
	public void editCar(Car car,PrintWriter out) {
		int result = service.editCar(car);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editLogCar", method = RequestMethod.POST)
	public void editLogCar(LogCar car,PrintWriter out) {
		int result = service.editLogCar(car);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
	public void deleteCar(Car car,PrintWriter out) {
		int result = service.deleteCar(car);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteLogCar", method = RequestMethod.POST)
	public void deleteLogCar(LogCar car,PrintWriter out) {
		int result = service.deleteLogCar(car);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/addTradeRecord",method = RequestMethod.POST)
	public void addTradeRecord(int carid,int thingid,User user,PrintWriter out){
		User owner = service.getUserByCarId(carid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");
		String reportNum = sdf.format(new Date()) + new Random().nextInt(9999);
		int result = service.addTradeRecord(carid,thingid,reportNum,owner,user);
		result = service.updateCarStatus(carid);
		result = service.updateThingStatus(thingid);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/tradeCar",method = RequestMethod.POST)
	public void tradeCar(int orderId,String carNum,PrintWriter out,User user){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");
		String recordNum = sdf.format(new Date()) + new Random().nextInt(9999);
		service.updateTradeRecord(orderId);
		int result = service.tradeCar(orderId,recordNum,carNum,user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/dispatch/{orderId}",method = RequestMethod.GET)
	public String getDispatch(@PathVariable String orderId,ModelMap map){
		Dispatch dispatch = service.getDispatch(Integer.valueOf(orderId));
		map.put("record", dispatch);
		return "print";
	}
}
