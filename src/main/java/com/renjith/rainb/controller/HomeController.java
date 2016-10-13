package com.renjith.rainb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@Autowired
	FacebookConnectionFactory fbConnectionFactory;

	@Autowired
	Environment env;

	@RequestMapping({ "/", "/home" })
	public String home(ModelMap model) {
		model.addAttribute("msg", "hello world");
		return "home";
	}

	/**
	 * if user is logged in and tries to access login page, it will redirect to
	 * home page as per user role
	 * 
	 * @param model
	 * @param request
	 * @return login page
	 */
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

	/**
	 * @return registration/sign-up page
	 */
	@RequestMapping("register")
	public String register() {
		return "register";
	}

	/**
	 * Ajax handler to register user. Called from register page
	 * 
	 * @param userDto
	 * @param model
	 * @return json object containing a boolean property <b>result</b> whose
	 *         value is true if sign up is a success, false if username is
	 *         already taken
	 */
	@RequestMapping("signup")
	public String signUp(UserDto userDto, ModelMap model) {
		model.addAttribute("result", userService.addUser(userDto));
		return "result";
	}

	@RequestMapping("fblogin")
	public void fbLogin(HttpServletResponse response) {
		OAuth2Operations oauthOperations = fbConnectionFactory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(env.getProperty("fb.redirect_url"));
		String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);
		try {
			response.sendRedirect(authorizeUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("fbcallback")
	public void fbCallback(@RequestParam(name = "code") String authCode, ModelMap model,
			HttpServletRequest request) {
		OAuth2Operations oauthOperations = fbConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(authCode, env.getProperty("fb.redirect_url"),
				null);
		// AccessGrant accessGrant = new AccessGrant(accessToken);
		Connection<Facebook> connection = fbConnectionFactory.createConnection(accessGrant);
		model.addAttribute("username", connection.getDisplayName());
		System.out.println(connection.getDisplayName());
		ConnectionData cd = connection.createData();
		// persist connection data
	
		// 
		connection.getApi();
	}
	
}
