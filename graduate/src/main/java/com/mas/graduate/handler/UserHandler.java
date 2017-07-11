package com.mas.graduate.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mas.graduate.entity.User;
import com.mas.graduate.service.IUserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserHandler {
	@Autowired
	private IUserService service;
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public String getAllUser(String username,String usertel,String usercompanyName,int pageNumber,int pageSize,PrintWriter out) {
		User user = new User();
		try {
			if(username != null){
				user.setUname(URLDecoder.decode(username,"utf-8"));
			}
			user.setUtel(usertel);
			user.setCompanyName(usercompanyName);
			user.setPageNumber(pageNumber);
			user.setPageSize(pageSize);
			List<User> users = service.getAllUserByPage(user);
			Gson gson = new Gson();
			String userStr = gson.toJson(users);
			String json = "{\"total\":" + service.getAllUser(user) + ",\"rows\":"
					+ userStr + "}";
			out.print(json);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user,ModelMap map) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		String username = resourceBundle.getString("jdbc.username");
		System.out.println(username);
		User login = service.findUser(user);
		if(login != null){
			map.put("user", login);
			if(login.getUtype().equals("普通用户")){
				return "car";
			}
			return "user";
		}else{
			map.put("loginError", "用户名或密码不正确");
		}
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user,ModelMap map) {
		user.setUtype("普通用户");
		int result = service.addUser(user);
		if(result>0){
			return "login";
		}
		return "register";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(User user,PrintWriter out) {
		user.setUpwd("123");
		int result = service.addUser(user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public void editUser(User user,PrintWriter out) {
		int result = service.editUser(user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(User user,PrintWriter out) {
		int result = service.deleteUser(user);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(PrintWriter out) {
		out.print( "{\"result\": 1," + " \"desc\": \"登录成功！\","
	            + "\"data\":{\"userinfo\":{\"gcid\":" + 1 + ",\"loginName\":"
	            + 1 + ",\"a\":"
	    	            + 12.99 + ",\"b\":"
	    	    	            + 1 + ",\"v\":"
	    	    	    	            + 1 + "}}}"
);
		out.flush();
		out.close();
	}
}
