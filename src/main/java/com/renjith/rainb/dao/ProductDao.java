package com.renjith.rainb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.renjith.rainb.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(product);
	}

}
