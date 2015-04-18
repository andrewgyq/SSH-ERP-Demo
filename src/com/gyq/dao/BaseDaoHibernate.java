package com.gyq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gyq.model.Customer;
@Repository
public class BaseDaoHibernate extends CustomHibernateDaoSupport  implements BaseDao {

	@Override
	public void save(Customer customer) {
		getHibernateTemplate().save(customer);
		
	}

	@Override
	public void update(Customer customer) {
		getHibernateTemplate().update(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		getHibernateTemplate().delete(customer);
		
	}

	@Override
	public Customer findById(String id) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find(
                "from Customer where CustomerId=?",id
           );
	return (Customer)list.get(0);
	}

}
