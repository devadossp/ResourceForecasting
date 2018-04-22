package com.cts.commsmedia.forecast.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.commsmedia.forecast.model.UserDetailsVO;
import com.cts.commsmedia.forecast.model.UserVO;
import com.cts.commsmedia.forecast.service.UserService;
import com.cts.commsmedia.forecast.utils.RFConstants;

@Controller
public class LoginController {

	@Autowired
	UserService service;

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView View(HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("login");
		UserVO loginbean = new UserVO();
		modelAndView.addObject("loginBean", loginbean);
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView Login(HttpServletRequest request, @ModelAttribute("loginBean") UserVO loginBean, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetailsVO userDetailsVO = new UserDetailsVO();
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();
		if (loginBean != null && userName != null && password != null) {
			userDetailsVO = service.isValidUser(userName, password);
			if (userDetailsVO.isValidUser()) {
				createSession(request, userDetailsVO);
				modelAndView = new ModelAndView("landing");
			} else {
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("msg", "Wrong user name or password");
			}
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("msg", "Error occurred while processing");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView homePage(HttpServletRequest request, @ModelAttribute("loginBean") UserVO loginBean,
			Model model) {
		return new ModelAndView("landing");
	}

	private void createSession(HttpServletRequest request, UserDetailsVO userDetailsVO) {
		HttpSession session = request.getSession(false);
		session.setAttribute(RFConstants.SESSION_USER_DETAILS, userDetailsVO);
	}
}
