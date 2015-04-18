package com.gyq.manager;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface LoginManager {

	Map<String, String> loginConfim(HttpServletRequest request);

}
