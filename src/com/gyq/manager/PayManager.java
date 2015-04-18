package com.gyq.manager;

import java.util.Map;

import com.gyq.model.Pay;

import net.sf.json.JSONObject;

public interface PayManager {


	public Map<String, String> savePay(Pay pay);

	public JSONObject getPayList(Map<String, String> searchMap);
	
	public int getPayListNum (Map<String, String> searchMap);

	public Map<String, String> updatePay(Pay pay);

	public Map<String, String> deletePay(String id);
}
