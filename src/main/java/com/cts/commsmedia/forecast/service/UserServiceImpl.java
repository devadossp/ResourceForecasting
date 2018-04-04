package com.cts.commsmedia.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.commsmedia.forecast.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
    @Autowired
    UserDAO userDao;

	public boolean isValidUser(String userName, String password) {
		return userDao.isValidUser(userName, password);
	}

}
