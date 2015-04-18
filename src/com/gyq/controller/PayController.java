package com.gyq.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gyq.manager.PayManager;
import com.gyq.model.Pay;

@Controller
@RequestMapping("/pay")
public class PayController {
	@Autowired
	private PayManager payManager;
	
	@RequestMapping("/getPayList")
	@ResponseBody
	public JSONObject getPayList(HttpServletRequest req , HttpServletResponse res){
		JSONObject json = new JSONObject();
		String page = req.getParameter("page");
		String rows = req.getParameter("rows");
		String name = req.getParameter("name");
		if(StringUtils.hasText(name)){
			try {
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String date = req.getParameter("date");
		Map<String,String> searchMap = new HashMap<String,String>();
		searchMap.put("page", page);
		searchMap.put("rows", rows);
		searchMap.put("name", name);
		searchMap.put("date", date);
		json = payManager.getPayList(searchMap);
		return json;
	}
	
	@RequestMapping("/payList")
	public ModelAndView payList(){
		return new ModelAndView("/pay/payList");
	}
	
	@RequestMapping("/addPay")
	public ModelAndView addPay(){
		return new ModelAndView("/pay/addPay");
	}
	
	@RequestMapping("/searchPay")
	public ModelAndView searchPay(){
		return new ModelAndView("/pay/searchPay");
	}
	
	@RequestMapping("/savePay")
	@ResponseBody
	public Map<String,String> savePay(HttpServletRequest req , HttpServletResponse res){
		Map<String,String> map = new HashMap<String,String>();
		Pay pay = new Pay();
		String name = req.getParameter("name");
		try {
			pay.setName(new String(name.getBytes("iso-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		pay.setPrice(Double.valueOf(req.getParameter("price")));
		String reason = req.getParameter("reason");
		try {
			pay.setReason(new String(reason.getBytes("iso-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		pay.setDate(Date.valueOf(req.getParameter("date")));
		String id = req.getParameter("id");
		pay.setId(id);
		if(StringUtils.hasText(id)){
		  map = payManager.updatePay(pay);
		}else{
		  map = payManager.savePay(pay);
		}
		return map;
	}
		
	@RequestMapping("/deletePay")
	@ResponseBody
	public Map<String,String> deletePay(HttpServletRequest req , HttpServletResponse res){
		Map<String,String> map = new HashMap<String,String>();
		String id = req.getParameter("id");
		if(StringUtils.hasText(id)){
		  map = payManager.deletePay(id);
		}else{
		  map.put("info", "fail");
		}
		return map;
  }

}
