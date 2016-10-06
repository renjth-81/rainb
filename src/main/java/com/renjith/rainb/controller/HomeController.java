package com.renjith.rainb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping({ "/", "/home" })
	public String home(ModelMap model) {
		model.addAttribute("msg", "hello world");
		return "home";
	}

	/**
	 * if user is logged in and tries to access login page, it will redirect to
	 * home page as per user role
	 * 
	 * @param model
	 * @param request
	 * @return login page
	 */
	@RequestMapping("/login")
	public String login(ModelMap model, HttpServletRequest request) {
		if (request.getSession() != null && request.getSession().getAttribute(RainbConstants.LOGIN_STATUS) != null) {
			int role = (Integer) request.getSession().getAttribute(RainbConstants.ROLE);
			if (role == RainbConstants.ADMIN_ROLE_ID) {
				return "redirect:/adm";
			} else {
				return "redirect:/usr";
			}
		}
		return "login";
	}

	@RequestMapping("error")
	public String error(HttpServletRequest request, ModelMap model) {
		String errorMsg = (String) request.getSession().getAttribute(RainbConstants.ERROR_PAGE_MESSAGE_ATTRIBUTE);
		model.addAttribute(RainbConstants.ERROR_PAGE_MESSAGE_ATTRIBUTE, errorMsg);
		request.getSession().removeAttribute(RainbConstants.ERROR_PAGE_MESSAGE_ATTRIBUTE);
		return "error";
	}

	/**
	 * @return registration/sign-up page
	 */
	@RequestMapping("register")
	public String register() {
		return "register";
	}

	/**
	 * Ajax handler to register user. Called from register page
	 * 
	 * @param userDto
	 * @param model
	 * @return json object containing a boolean property <b>result</b> whose
	 *         value is true if sign up is a success, false if username is
	 *         already taken
	 */
	@RequestMapping("signup")
	public String signUp(UserDto userDto, ModelMap model) {
		model.addAttribute("result", userService.addUser(userDto));
		return "result";
	}
	
}
