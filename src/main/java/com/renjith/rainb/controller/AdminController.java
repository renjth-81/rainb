package com.renjith.rainb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminController {

	@RequestMapping("adm")
	public String adminHome(ModelMap model) {
		return "adminhome";
	}

}
