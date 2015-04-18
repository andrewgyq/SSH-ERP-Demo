package com.gyq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gyq.manager.BaseManager;
import com.gyq.model.Customer;

@Controller
@RequestMapping("/base")
public class BaseController {
	
	@RequestMapping("/customerList")
	public ModelAndView payList(){
		return new ModelAndView("/base/customerList");
	}
	
	@Autowired
	private BaseManager baseManager;
	@RequestMapping("/saveCustomer")
	@ResponseBody
	public Map<String,String> savePay(HttpServletRequest req , HttpServletResponse res){
		Map<String,String> map = new HashMap<String,String>();
		Customer customer = new Customer();
		customer.setCustomerName("11111");
		customer.setCustomerType("1");
		customer.setRemark("1111111111111");
		customer.setCreateDate(new Date());
		baseManager.save(customer);
		return map;
	}
		

}
