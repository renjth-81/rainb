package com.renjith.rainb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

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
	public String userHome(ModelMap model, HttpServletRequest request) {
		model.addAttribute(RainbConstants.USER_ID, request.getSession().getAttribute(RainbConstants.USER_ID));
		return "userhome";
	}

	@RequestMapping("usrall")
	public String all(ModelMap model) {
		model.addAttribute("users", userService.getAll());
		return "users";
	}

	@RequestMapping("usrdash")
	public String dashBoard(ModelMap model) {
		return "userdashboard";
	}

	@RequestMapping("usrchgpwd")
	public String changePassword(ModelMap model, HttpServletRequest request, UserDto userDto) {
		model.addAttribute("result", userService.changePassword(userDto.getPassword(),
				(Integer) request.getAttribute(RainbConstants.USER_ID)));
		return "result";
	}

	@RequestMapping("usrchat")
	public String userChat(HttpServletRequest request) {
		return "userchat";
	}

}
