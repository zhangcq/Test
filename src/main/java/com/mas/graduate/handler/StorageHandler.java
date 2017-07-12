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
import com.mas.graduate.entity.Storage;
import com.mas.graduate.service.IStorageService;

@Controller
@RequestMapping("/storage")
@SessionAttributes("user")
public class StorageHandler {
	@Autowired
	private IStorageService service;
	
	@RequestMapping(value = "/getAllStorage", method = RequestMethod.GET)
	public String getAllUser(String storageNum,String location,String type,int pageNumber,int pageSize,PrintWriter out) {
		Storage storage = new Storage();
		try {
			if(storageNum != null){
				storage.setStorageNum(URLDecoder.decode(storageNum,"utf-8"));
			}
			if(location != null){
				storage.setLocation(URLDecoder.decode(location,"utf-8"));
			}
			if(type != null){
				storage.setType(URLDecoder.decode(type,"utf-8"));
			}
			storage.setPageNumber(pageNumber);
			storage.setPageSize(pageSize);
			List<Storage> storages = service.getAllStorageByPage(storage);
			Gson gson = new Gson();
			String userStr = gson.toJson(storages);
			String json = "{\"total\":" + service.getAllStorage(storage) + ",\"rows\":"
					+ userStr + "}";
			out.print(json);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "storage";
	}
	
	@RequestMapping(value = "/addStorage", method = RequestMethod.POST)
	public void addUser(Storage storage,PrintWriter out) {
		int result = service.addStorage(storage);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editStorage", method = RequestMethod.POST)
	public void editUser(Storage storage,PrintWriter out) {
		int result = service.editStorage(storage);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteStorage", method = RequestMethod.POST)
	public void deleteUser(Storage storage,PrintWriter out) {
		int result = service.deleteStorage(storage);
		out.print(result);
		out.flush();
		out.close();
	}
}
