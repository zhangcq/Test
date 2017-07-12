package com.mas.graduate.service;

import java.util.List;


import com.mas.graduate.entity.User;

public interface IUserService {

	int getAllUser(User user);

	List<User> getAllUserByPage(User user);

	User findUser(User user);

	int addUser(User user);

	int editUser(User user);

	int deleteUser(User user);

}
