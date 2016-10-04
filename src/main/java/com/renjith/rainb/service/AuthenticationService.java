package com.renjith.rainb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import com.renjith.rainb.dao.UserDao;
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.model.User;

public class AuthenticationService implements AuthenticationProvider {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String password = authentication.getCredentials().toString();
		String username = authentication.getName();
		User user = userDao.findByUsernameAndPassword(username, password);
		List<GrantedAuthority> grantedAuths = null;
		if (user != null) {
			grantedAuths = new ArrayList<GrantedAuthority>();
			if (user.getRole() == RainbConstants.USER_ROLE_ID) {
				grantedAuths.add(new SimpleGrantedAuthority(RainbConstants.USER_ROLE_NAME));
			} else {
				grantedAuths.add(new SimpleGrantedAuthority(RainbConstants.ADMIN_ROLE_NAME));
			}
			Authentication auth = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
			return auth;
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
