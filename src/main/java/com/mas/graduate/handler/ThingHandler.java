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
import com.mas.graduate.entity.Thing;
import com.mas.graduate.entity.User;
import com.mas.graduate.service.IThingService;

@Controller
@RequestMapping("/thing")
@SessionAttributes("user")
public class ThingHandler {
	@Autowired
	private IThingService service;
	
	@RequestMapping(value = "/getAllThing", method = RequestMethod.GET)
	public String getAllThing(String departure,String destination,String releaseTimeBegin,String releaseTimeEnd,int pageNumber,int pageSize,PrintWriter out) {
		Thing thing = new Thing();
		try {
			if(departure != null){
				thing.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				thing.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(releaseTimeBegin != null){
				thing.setReleaseTimeBegin(URLDecoder.decode(releaseTimeBegin,"utf-8"));
			}
			if(releaseTimeEnd != null){
				thing.setReleaseTimeEnd(URLDecoder.decode(releaseTimeEnd,"utf-8"));
			}
			thing.setPageNumber(pageNumber);
			thing.setPageSize(pageSize);
			List<Thing> things = service.getAllThingByPage(thing);
			Gson gson = new Gson();
			String userStr = gson.toJson(things);
			String json = "{\"total\":" + service.getAllThing(thing) + ",\"rows\":"
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
	
	@RequestMapping(value = "/getAllMyThing", method = RequestMethod.GET)
	public String getAllMyThing(String departure,String destination,String releaseTimeBegin,String releaseTimeEnd,int pageNumber,int pageSize,PrintWriter out,User user) {
		Thing thing = new Thing();
		try {
			if(departure != null){
				thing.setDeparture(URLDecoder.decode(departure,"utf-8"));
			}
			if(destination != null){
				thing.setDestination(URLDecoder.decode(destination,"utf-8"));
			}
			if(releaseTimeBegin != null){
				thing.setReleaseTimeBegin(URLDecoder.decode(releaseTimeBegin,"utf-8"));
			}
			if(releaseTimeEnd != null){
				thing.setReleaseTimeEnd(URLDecoder.decode(releaseTimeBegin,"utf-8"));
			}
			thing.setPageNumber(pageNumber);
			thing.setPageSize(pageSize);
			List<Thing> things = service.getAllMyThingByPage(thing,user);
			Gson gson = new Gson();
			String userStr = gson.toJson(things);
			String json = "{\"total\":" + service.getAllMyThing(thing,user) + ",\"rows\":"
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
	
	@RequestMapping(value = "/getAllMyThingCount", method = RequestMethod.POST)
	public void getAllMyThingCount(Thing thing,User user,PrintWriter out) {
		int count = service.getAllMyThing(thing,user);
		out.print(count);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/addThing", method = RequestMethod.POST)
	public void addThing(Thing thing,User user,PrintWriter out) {
		int result = service.addThing(thing,user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editThing", method = RequestMethod.POST)
	public void editThing(Thing thing,PrintWriter out) {
		int result = service.editThing(thing);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteThing", method = RequestMethod.POST)
	public void deleteThing(Thing thing,PrintWriter out) {
		int result = service.deleteThing(thing);
		out.print(result);
		out.flush();
		out.close();
	}
}
