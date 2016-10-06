package com.renjith.rainb.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptHasher implements PasswordHasher {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public String encode(String password) {
		return encoder.encode(password);
	}

	@Override
	public boolean matches(String rawInput, String encodedPassword) {
		return encoder.matches(rawInput, encodedPassword);
	}

}
