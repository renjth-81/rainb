package com.renjith.rainb.init;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

	@Autowired
	Environment env;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// String appUrl = env.getProperty("app.url");
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();

		String pageRequested = url.toString().substring(url.indexOf(uri));
		System.out.println(pageRequested);

		// if user accesses common home page after login, don't allow ,
		// redirect to appropriate home page as per user role

		// if (pageRequested.endsWith("/") &&
		// request.getSession().getAttribute(RainbConstants.LOGIN_STATUS) !=
		// null) {
		// int role = (Integer)
		// request.getSession().getAttribute(RainbConstants.ROLE);
		// if (role == RainbConstants.ADMIN_ROLE_ID) {
		// response.sendRedirect(request.getContextPath() +
		// RainbConstants.ADMIN_LOGIN_SUCCESS_PAGE);
		// } else {
		// response.sendRedirect(request.getContextPath() +
		// RainbConstants.USER_LOGIN_SUCCESS_PAGE);
		// }
		// return false;
		// }

		
		// user logged in and accesses login page, redirect to appropriate
		// home page
		
		// if (request.getSession(false) != null
		// &&
		// request.getSession(false).getAttribute(RainbConstants.LOGIN_STATUS)
		// != null) {
		// int role = (Integer)
		// request.getSession().getAttribute(RainbConstants.ROLE);
		// for (String p : RainbConstants.pagesBeforeLogin) {
		// if (pageRequested.contains(p)) {
		// if (role == RainbConstants.ADMIN_ROLE_ID) {
		// response.sendRedirect(request.getContextPath() +
		// RainbConstants.ADMIN_LOGIN_SUCCESS_PAGE);
		// } else {
		// response.sendRedirect(request.getContextPath() +
		// RainbConstants.USER_LOGIN_SUCCESS_PAGE);
		// }
		// return false;
		// }
		// }
		// }
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
																					// 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
