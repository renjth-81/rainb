package com.renjith.rainb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private int id;

	private String username;
	private String password;

	@Column(name = "login_status")
	private byte loginStatus;
	
	// 1 - admin, 2 - user
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
