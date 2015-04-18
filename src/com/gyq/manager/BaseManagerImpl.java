package com.gyq.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.dao.BaseDao;
import com.gyq.model.Customer;
@Service
public class BaseManagerImpl implements BaseManager {
    @Autowired
    BaseDao baseDao;
    
    public void setStockDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(Customer customer) {
		baseDao.save(customer);
		
	}

	@Override
	public void update(Customer customer) {
		baseDao.update(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		baseDao.delete(customer);
		
	}

	@Override
	public Customer findById(String id) {
		return baseDao.findById(id);
	}

}
