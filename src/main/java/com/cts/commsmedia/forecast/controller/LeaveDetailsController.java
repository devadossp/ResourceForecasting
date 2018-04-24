package com.cts.commsmedia.forecast.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.commsmedia.forecast.dto.LeaveDetailsDTO;
import com.cts.commsmedia.forecast.dto.UserDetailsDto;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.service.UserService;
import com.cts.commsmedia.forecast.utils.CommonUtils;
import com.cts.commsmedia.forecast.utils.RFConstants;

@Controller
public class LeaveDetailsController extends BaseController{
	
	@Autowired
	UserService service;

	@RequestMapping(value = "/leaveplans", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView leavePlans(HttpServletRequest request,
			@ModelAttribute("userDetailsScreenVO") UserDetailsScreenVO userDetailsScreenVO, Model model) {
		UserDetailsVO userDetailsVO = null;
		userDetailsVO = getUserDetails(request);
		if (userDetailsVO != null) {
			userDetailsScreenVO = service.getLocationDetails();
			userDetailsScreenVO.setFullname(userDetailsVO.getAssociateDetails().getAssociateName());
			userDetailsScreenVO.setEmpID(userDetailsVO.getAssociateDetails().getAssociateId());
			userDetailsScreenVO.setProjectId(userDetailsVO.getAssociateDetails().getProjectName());
			getMonths(userDetailsScreenVO);
			model.addAttribute("userDetailsScreenVO", userDetailsScreenVO);
		} else {
			return new ModelAndView("login");
		}

		return new ModelAndView("leavedetails");
	}
	
	private void getMonths(UserDetailsScreenVO userDetailsScreenVO) {
		ArrayList<UserDetailsDto> months = new ArrayList<UserDetailsDto>();

		UserDetailsDto currentMonthDetails = new UserDetailsDto();
		currentMonthDetails.setMonth_id(CommonUtils.getMonth(RFConstants.CURRENT_MONTH, RFConstants.MONTHS.ID));
		currentMonthDetails.setMonth_name(CommonUtils.getMonth(RFConstants.CURRENT_MONTH, RFConstants.MONTHS.NAME));
		months.add(currentMonthDetails);
		UserDetailsDto nextMonthDetails = new UserDetailsDto();
		nextMonthDetails.setMonth_id(CommonUtils.getMonth(RFConstants.NEXT_MONTH, RFConstants.MONTHS.ID));
		nextMonthDetails.setMonth_name(CommonUtils.getMonth(RFConstants.NEXT_MONTH, RFConstants.MONTHS.NAME));

		months.add(nextMonthDetails);
		userDetailsScreenVO.setMonth_list(months);
	}
	
	@RequestMapping(value = "/saveLeaves", method = { RequestMethod.POST })
	public @ResponseBody LeaveDetailsDTO saveLeaveDetails(HttpServletRequest request,
			@RequestBody LeaveDetailsDTO leaveDetailsDTO, Model model) {
		UserDetailsVO userDetailsVO = null;
		userDetailsVO = getUserDetails(request);
		if (userDetailsVO != null) {
			leaveDetailsDTO.setLocation_id(userDetailsVO.getLocationDetails().getLocationId());
			leaveDetailsDTO.setCrnumber(userDetailsVO.getAssociateDetails().getCrnumber());
			leaveDetailsDTO.setGrouping("Gold NFR");// Check
			String location_id = String.valueOf(userDetailsVO.getLocationDetails().getLocationId());
			location_id = RFConstants.UNDER_SCORE + location_id;
			leaveDetailsDTO.setTotalworkingdays(userDetailsVO.getLocationDetails().getMonthly_working_days()
					.get(leaveDetailsDTO.getMonth_name() + location_id));
			leaveDetailsDTO.setRate(userDetailsVO.getAssociateDetails().getRatePerHour());
			leaveDetailsDTO.setFromdate_timestamp(
					CommonUtils.convertStringToTimestamp(leaveDetailsDTO.getFromdate() + RFConstants.FROM_DATE_FORMAT));
			leaveDetailsDTO.setTodate_timestamp(
					CommonUtils.convertStringToTimestamp(leaveDetailsDTO.getTodate() + RFConstants.TO_DATE_FORMAT));
			service.insertLeaveDetails(leaveDetailsDTO);
		}
		return leaveDetailsDTO;
	}
}
