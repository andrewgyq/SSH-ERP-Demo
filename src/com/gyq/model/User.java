package com.gyq.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user", catalog = "test")
public class User{
	
	private int userId;
	private String userName;
	private String userPassword;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "USER_NAME", nullable = false, length = 20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "USER_PASSWORD", nullable = false, length = 10)
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
	

}
