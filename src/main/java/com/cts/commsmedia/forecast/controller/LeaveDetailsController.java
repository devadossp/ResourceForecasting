package com.cts.commsmedia.forecast.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.service.UserService;
import com.cts.commsmedia.forecast.utils.RFConstants;

@Controller
public class LeaveDetailsController {
	
	@Autowired
	UserService service;

	@RequestMapping(value = "/leaveplans", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView leavePlans(HttpServletRequest request,
			@ModelAttribute("userDetailsScreenVO") UserDetailsScreenVO userDetailsScreenVO, Model model) {
		HttpSession session = request.getSession(false);
		UserDetailsVO userDetailsVO = null;
		if (session != null && session.getAttribute(RFConstants.SESSION_USER_DETAILS) != null) {
			userDetailsVO = (UserDetailsVO) session.getAttribute(RFConstants.SESSION_USER_DETAILS);
		}
		userDetailsScreenVO = service.getLocationDetails();
		userDetailsScreenVO.setProjectId(userDetailsVO.getAssociateDetails().getProjectName());
		model.addAttribute("userDetailsScreenVO", userDetailsScreenVO);
		return new ModelAndView("leavedetails");
	}

}
