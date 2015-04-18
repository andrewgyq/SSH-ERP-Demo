package com.gyq.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.dao.PayDao;
import com.gyq.model.Pay;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class PayManagerImpl implements PayManager {
    @Autowired
    private PayDao payDao;
	@Override
	public JSONObject getPayList(Map<String, String> searchMap) {
		List<Object[]> payList = payDao.getPayList(searchMap);
		int num = payDao.getPayListNum(searchMap);
		JSONObject json = new JSONObject();
		JSONArray rows = new JSONArray();
		JSONObject row = new JSONObject();
		JSONArray footers = new JSONArray();
		JSONObject footer = new JSONObject();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		double priceT = 0.0;
		for(Object[] obj : payList){
			row.put("id", obj[0]);
			row.put("name", obj[1]);
			row.put("price", obj[2]);
			priceT = priceT + (Double)obj[2];
			row.put("reason", obj[3]);
			row.put("date", df.format((Date)obj[4]));
			rows.add(row);
		}
		footer.put("name", "±¾Ò³×Ü¼Æ");
		footer.put("price", priceT);
		footers.add(footer);
		json.put("rows", rows);
		json.put("footer", footers);
		json.put("total", num);
		return json;
	}
	@Override
	public Map<String, String> savePay(Pay pay) {
		Map<String, String>  map = new HashMap<String, String> ();
		int num = payDao.savePay(pay);
		if(num>0){
			map.put("info", "success");
		}else{
			map.put("info", "fail");
		}
		return map;
	}
	@Override
	public int getPayListNum(Map<String, String> searchMap) {
		return payDao.getPayListNum(searchMap);
	}
	@Override
	public Map<String, String> updatePay(Pay pay) {
		Map<String, String>  map = new HashMap<String, String> ();
		int num = payDao.updatePay(pay);
		if(num>0){
			map.put("info", "success");
		}else{
			map.put("info", "fail");
		}
		return map;
	}
	@Override
	public Map<String, String> deletePay(String id) {
		Map<String, String>  map = new HashMap<String, String> ();
		int num = payDao.deletePay(id);
		if(num>0){
			map.put("info", "success");
		}else{
			map.put("info", "fail");
		}
		return map;
	}

}
