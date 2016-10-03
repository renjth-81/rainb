package com.renjith.rainb.service;

import java.util.List;

import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.PaymentError;
import com.renjith.rainb.model.User;

public interface UserService {

	public List<User> getAll();

	public boolean addUser(UserDto userDto) throws PaymentError;

}
