package com.renjith.rainb.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import com.renjith.rainb.init.RainbConstants;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
			throws IOException, ServletException {
		if (exception instanceof MissingCsrfTokenException) {
			// timeout
			response.sendRedirect(request.getContextPath() + RainbConstants.LOGIN_PAGE_TIMEOUT);
		} else {
			// 403 error - access denied
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			request.getSession().setAttribute(RainbConstants.ERROR_PAGE_MESSAGE_ATTRIBUTE,
					RainbConstants.ACCESS_DENIED_ERR_MSG);
			response.sendRedirect(request.getContextPath() + RainbConstants.ERROR_PAGE);
		}
	}
}
