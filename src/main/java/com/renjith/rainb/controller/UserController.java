package com.renjith.rainb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.PaymentError;
import com.renjith.rainb.service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

	// @RequestMapping("all")
	// public String all(ModelMap model) {
	// model.addAttribute("users", userService.getAll());
	// return "users";
	// }
	//
	// @RequestMapping("add")
	// public String add(@RequestParam int id) throws PaymentError {
	// UserDto userDto = new UserDto();
	// userDto.setId(id);
	// userDto.setUsername("test2");
	// userDto.setPassword("test34!@");
	// userDto.setLoginStatus((byte) 1);
	// userService.addUser(userDto);
	// return "success";
	// }

	
	@RequestMapping("usr")
	public String userHome(ModelMap model) {
		return "userhome";
	}
	
}
