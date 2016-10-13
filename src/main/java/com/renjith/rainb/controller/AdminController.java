package com.renjith.rainb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.renjith.rainb.dto.ProductDto;
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.service.AdminService;

@Controller
@RequestMapping
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("adm")
	public String adminHome(ModelMap model) {
		return "adminhome";
	}

	@RequestMapping("admaddprodpage")
	public String adminAddProductPage(ModelMap model) {
		return "addproduct";
	}

	@RequestMapping("admsaveprod")
	public String adminSaveProduct(ProductDto productDto, ModelMap model, HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(RainbConstants.PRODUCT_IMAGE);
		model.addAttribute("result", adminService.addProduct(productDto, file));
		return "result";
	}

}
