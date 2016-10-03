package com.renjith.rainb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.renjith.rainb.model.User;

@Repository
public class UserDao {

	// public UserDao(User type) {
	// super(type);
	// }

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
