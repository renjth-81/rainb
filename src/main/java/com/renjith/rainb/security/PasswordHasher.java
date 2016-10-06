package com.renjith.rainb.security;

public interface PasswordHasher {

	public String encode(String password);

	public boolean matches(String rawInput, String encodedPassword);
}
