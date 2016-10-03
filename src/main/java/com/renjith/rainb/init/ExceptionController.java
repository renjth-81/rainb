package com.renjith.rainb.init;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = PaymentError.class)
	public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/error");
		// redirectAttributes.addFlashAttribute("msg", e.getMessage());
		// mav.addObject("errMsg", e.getMessage());
		// mav.setViewName("redirect:/error");
		request.getSession().setAttribute("errMsg", e.getMessage());
		return mav;
	}

}
