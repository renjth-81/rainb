package com.renjith.rainb.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renjith.rainb.dao.UserDao;
import com.renjith.rainb.dto.UserDto;
import com.renjith.rainb.init.PaymentError;
import com.renjith.rainb.model.User;
import com.renjith.rainb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	Environment env;

	@Override
	@Transactional
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional(rollbackFor = PaymentError.class)
	public boolean addUser(UserDto userDto) throws PaymentError {
		User u = new User();
		BeanUtils.copyProperties(userDto, u);
		userDao.save(u);
		if (userDto.getId() > 5) {
			throw new PaymentError(env.getProperty("payment.error"));
		}
		return false;
	}

}
