package com.gyq.dao;

import com.gyq.model.Customer;

public interface BaseDao {

	void save(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	Customer findById(String id);

}
