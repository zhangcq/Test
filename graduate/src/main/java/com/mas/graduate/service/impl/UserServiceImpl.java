package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.User;
import com.mas.graduate.mapper.UserMapper;
import com.mas.graduate.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int getAllUser(User user) {
		return userMapper.getAllUser(user);
	}

	@Override
	public List<User> getAllUserByPage(User user) {
		return userMapper.getAllUserByPage(user);
	}

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int editUser(User user) {
		return userMapper.editUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

}
