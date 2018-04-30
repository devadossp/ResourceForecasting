package com.cts.commsmedia.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.commsmedia.forecast.dao.UserDAO;
import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
    @Autowired
    UserDAO userDao;

	public UserDetailsVO isValidUser(String userName, String password) {
		return userDao.isValidUser(userName, password);
	}
	
	public UserDetailsScreenVO getLocationDetails(){
		return userDao.getLocationDetails();
	}
	
	public int insertLeaveDetails(final LeaveDetailsDTO leaveDetailsDTO){
		return userDao.insertLeaveDetails(leaveDetailsDTO);
	}
}
