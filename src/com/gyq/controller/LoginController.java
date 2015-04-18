package com.gyq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gyq.manager.LoginManager;

@Controller
public class LoginController {
	@Autowired
	private LoginManager loginManger;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("/login");
	}
	
	@RequestMapping("/loginConfim")
	public ModelAndView loginConfim(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		map = loginManger.loginConfim(request);
		if("1".equals(map.get("flag"))){
			return new ModelAndView("/index",map);
		}else{
		    return new ModelAndView("/error");
		}
	}

}
