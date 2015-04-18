package com.gyq.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.dao.LoginDao;
@Service
public class LoginMangerImpl implements LoginManager {
	@Autowired
	private LoginDao loginDao;

	@Override
	public Map<String, String> loginConfim(HttpServletRequest request) {
		boolean flag = false;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		flag = loginDao.loginConfim(id,password);
		Map<String, String> map = new HashMap<String,String> ();
		if(flag){
			map.put("flag", "1");
		}
		return map;
	}

}
