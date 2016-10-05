package com.renjith.rainb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renjith.rainb.init.RainbConstants;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/home" })
	public String home(ModelMap model) {
		model.addAttribute("msg", "hello world");
		return "home";
	}

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

}
