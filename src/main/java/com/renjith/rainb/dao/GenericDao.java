package com.renjith.rainb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class GenericDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private final Class type;

	public GenericDao(T type) {
		this.type = type.getClass();
	}

	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(type).list();
	}

}
