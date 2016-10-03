package com.renjith.rainb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/home" })
	public String home(ModelMap model) {
		model.addAttribute("msg", "hello world");
		return "home";
	}

	@RequestMapping("error")
	public String error(HttpServletRequest request, ModelMap model) {
		String errorMsg = (String) request.getSession().getAttribute("errMsg");
		model.addAttribute("errMsg", errorMsg);
		request.getSession().removeAttribute("errMsg");
		return "error";
	}

}
