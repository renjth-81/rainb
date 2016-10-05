package com.renjith.rainb.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.renjith.rainb.init.RainbConstants;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		Iterator<SimpleGrantedAuthority> i = (Iterator<SimpleGrantedAuthority>) auth.getAuthorities().iterator();
		while (i.hasNext()) {
			SimpleGrantedAuthority authority = i.next();
			request.getSession().setAttribute(RainbConstants.LOGIN_STATUS, RainbConstants.LOGIN_STATUS_YES);
			if (authority.getAuthority().equals(RainbConstants.ADMIN_ROLE_NAME)) {
				response.sendRedirect(request.getContextPath() + RainbConstants.ADMIN_LOGIN_SUCCESS_PAGE);
				request.getSession().setAttribute(RainbConstants.ROLE, RainbConstants.ADMIN_ROLE_ID);
			} else {
				response.sendRedirect(request.getContextPath() + RainbConstants.USER_LOGIN_SUCCESS_PAGE);
				request.getSession().setAttribute(RainbConstants.ROLE, RainbConstants.USER_ROLE_ID);
			}
		}
	}

}
