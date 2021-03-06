package com.renjith.rainb.dto;

public class UserDto {
	private int id;
	private String username;
	private String password;
	private byte loginStatus;
	private int role;

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(byte loginStatus) {
		this.loginStatus = loginStatus;
	}

}
