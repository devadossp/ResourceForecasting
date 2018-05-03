package com.cts.commsmedia.forecast.service;

import java.util.List;

import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;

public interface UserService {

	 public UserDetailsVO isValidUser(String userName, String password);
	 
	 public UserDetailsScreenVO getLocationDetails();
	 
	 public int insertLeaveDetails(LeaveDetailsDTO leaveDetailsDTO);
	 
	 public List getLeaveDetails(String associate_id);
}
