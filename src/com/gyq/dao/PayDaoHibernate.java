package com.gyq.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.gyq.model.Pay;

@Repository
public class PayDaoHibernate extends CustomHibernateDaoSupport implements PayDao {
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPayList(Map<String, String> searchMap) {
		String page = searchMap.get("page");
		String rows = searchMap.get("rows");
		String name = searchMap.get("name");
		String date = searchMap.get("date");
		int start = Integer.valueOf(page);
		int i = Integer.valueOf(rows);
		StringBuffer sql = new StringBuffer();
		sql.append("select * from pay ");
		sql.append("where 1=1 ");
		if(StringUtils.hasText(name)){
			sql.append("and  name like '%"+name+"%' ");
		}
		if(StringUtils.hasText(date)){
			sql.append("and date = '"+date+"'");
		}
		sql.append("order by  date DESC ");
		sql.append("limit  ");
		sql.append((start-1)*i);
		sql.append(" , ");
		sql.append(i);
		SQLQuery query = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql.toString());
		return query.list();
	}

	@Override
	public int savePay(Pay pay) {
		
		getHibernateTemplate().save(pay);
		return 1;
		
	}

	@Override
	public int getPayListNum(Map<String, String> searchMap) {
		StringBuffer sql = new StringBuffer();
		String name = searchMap.get("name");
		String date = searchMap.get("date");
		sql.append("select count(*) from pay ");
		sql.append("where 1=1 ");
		if(StringUtils.hasText(name)){
			sql.append("and  name like '%"+name+"%' ");
		}
		if(StringUtils.hasText(date)){
			sql.append("and date = '"+date+"'");
		}
		SQLQuery query = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql.toString());
		BigInteger num = (BigInteger)query.uniqueResult();
		return num.intValue();
	}

	@Override
	public int updatePay(Pay pay) {
		getHibernateTemplate().update(pay);
		return 1;
	}

	@Override
	public int deletePay(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from pay  ");
		sql.append("where id = '"+id+"' ");
		SQLQuery query = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql.toString());
		int num = query.executeUpdate();
		return num;
	}

}
