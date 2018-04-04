package com.cts.commsmedia.forecast.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.commsmedia.forecast.model.UserVO;
import com.cts.commsmedia.forecast.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView View(HttpServletRequest request) throws IOException {
     
     ModelAndView modelAndView = new ModelAndView("login");
     UserVO loginbean = new UserVO();
     modelAndView.addObject("loginBean", loginbean);
     return modelAndView;
     }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request, @ModelAttribute("loginBean") UserVO loginBean) {
		boolean result;
		ModelAndView modelAndView = null;
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();

		if (loginBean != null && userName != null && password != null) {
			result = service.isValidUser(userName, password);
			if (result) {
				modelAndView = new ModelAndView("landing");
			} else {
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("msg", "Wrong user name or password");
			}
		} else {
			modelAndView = new ModelAndView("loginpage");
			modelAndView.addObject("msg", "Error occurred while processing");
		}
		return modelAndView;
	}
}
