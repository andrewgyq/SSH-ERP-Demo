package com.gyq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class LoginDaoHibernate extends CustomHibernateDaoSupport implements LoginDao {
	
	
	@Override
	public boolean loginConfim(String id, String password) {
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find(
                "from User where userName=? and userPassword=?",
                new Object[]{id,password}
           );
		
		int a = list.size();
		if(a>0){
			return true;
		}else{
		    return false;
		}
	}

}
