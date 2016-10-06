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
import com.renjith.rainb.init.RainbConstants;
import com.renjith.rainb.model.User;
import com.renjith.rainb.security.PasswordHasher;
import com.renjith.rainb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	Environment env;

	@Autowired
	PasswordHasher hasher;

	@Override
	@Transactional
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public boolean addUser(UserDto userDto) {
		User user = userDao.findByUsername(userDto.getUsername());
		if (user != null) {
			return false;
		}
		userDto.setPassword(hasher.encode(userDto.getPassword()));
		user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setRole(RainbConstants.USER_ROLE_ID);
		userDao.save(user);
		return true;
	}

	@Override
	@Transactional
	public boolean changePassword(String newPassword, int userId) {
		User user = userDao.findOne(userId);
		user.setPassword(hasher.encode(newPassword));
		userDao.save(user);
		return true;
	}

}
