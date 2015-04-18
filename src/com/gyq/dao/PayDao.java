package com.gyq.dao;

import java.util.List;
import java.util.Map;

import com.gyq.model.Pay;


public interface PayDao {

	public List<Object[]> getPayList(Map<String, String> searchMap);

	public int savePay(Pay pay);

	public int getPayListNum(Map<String, String> searchMap);

	public int updatePay(Pay pay);

	public int deletePay(String id);
}
