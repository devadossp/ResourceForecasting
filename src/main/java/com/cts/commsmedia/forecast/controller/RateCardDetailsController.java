package com.cts.commsmedia.forecast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.commsmedia.forecast.model.RateCardDetailsVO;
import com.cts.commsmedia.forecast.model.UserDetailsScreenVO;
import com.cts.commsmedia.forecast.service.RateCardService;
import com.cts.commsmedia.forecast.service.UserService;

@Controller
public class RateCardDetailsController extends BaseController {

	@Autowired
	UserService service;

	@Autowired
	RateCardService rateCardService;

	@RequestMapping(value = "/rateCardMaster", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView rateCardMaster(HttpServletRequest request,
			@ModelAttribute("rateCardDetailsVO") RateCardDetailsVO rateCardDetailsVO, Model model) {
		UserDetailsScreenVO userDetailsScreenVO = null;
		userDetailsScreenVO = service.getLocationDetails();
		rateCardDetailsVO = rateCardService.getSkillDetails();
		rateCardDetailsVO = rateCardService.getDeptDetails();
		rateCardDetailsVO.setLocationList(userDetailsScreenVO.getLocation_list());
		model.addAttribute("rateCardDetailsVO", rateCardDetailsVO);
		return new ModelAndView("rateCardDetails");
	}
}
