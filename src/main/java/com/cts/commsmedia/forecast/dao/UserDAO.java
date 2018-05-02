package com.cts.commsmedia.forecast.dao;

import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;

public interface UserDAO {

	 public UserDetailsVO isValidUser(String userName, String password);
	 
	 public UserDetailsScreenVO getLocationDetails();
	 
	 public int insertLeaveDetails(LeaveDetailsDTO leaveDetailsDTO);
}
