package com.gyq.manager;


import com.gyq.model.Customer;

public interface BaseManager {

	void save(Customer stock);
	void update(Customer stock);
	void delete(Customer stock);
	Customer findById(String id);

}
