package com.cts.commsmedia.forecast.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	private void getMonths(UserDetailsScreenVO userDetailsScreenVO)
	{
		ArrayList<UserDetailsDto> months = new ArrayList<UserDetailsDto>();
		
		UserDetailsDto currentMonthDetails = new UserDetailsDto();
		currentMonthDetails.setMonth_id("4");
		currentMonthDetails.setMonth_name("April");
		months.add(currentMonthDetails);
		
		UserDetailsDto nextMonthDetails = new UserDetailsDto();
		nextMonthDetails.setMonth_id("5");
		nextMonthDetails.setMonth_name("May");
		
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
			leaveDetailsDTO.setTotalworkingdays(22);// code change
			leaveDetailsDTO.setRate(userDetailsVO.getAssociateDetails().getRatePerHour());
		}
		System.out.println("Location Id:: "+ leaveDetailsDTO.getLocation_id());
		System.out.println("Associate Id:: "+ leaveDetailsDTO.getAssociate_id());
		System.out.println("CR Number:: "+ leaveDetailsDTO.getCrnumber());
		System.out.println("Grouping:: "+ leaveDetailsDTO.getGrouping());
		System.out.println("Total Hours:: "+ leaveDetailsDTO.getTotalhours());
		System.out.println("Total Working Days:: "+ leaveDetailsDTO.getTotalworkingdays());
		System.out.println("Month:: "+ leaveDetailsDTO.getMonth_name());
		System.out.println("Working Hours:: "+ leaveDetailsDTO.getWorkinghours());
		System.out.println("Rate:: "+ leaveDetailsDTO.getRate());
		System.out.println("From Date:: "+ leaveDetailsDTO.getFromdate());
		System.out.println("To Date:: "+ leaveDetailsDTO.getTodate());
		System.out.println("No Of Days:: "+ leaveDetailsDTO.getNoofdays());
		
		return leaveDetailsDTO;
	}
}
