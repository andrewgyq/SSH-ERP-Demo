package com.gyq.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "customer", catalog = "test")
public class Customer {
	private int customerId;
	private String customerName;
	private String remark;
	private String customerType;
	private Date createDate;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CUSTOMER_ID", nullable = false)
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "CUSTOMER_NAME", nullable = false, length = 20)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Column(name = "REMARK", nullable = true, length = 50)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "CUSTOMER_TYPE", nullable = true, length = 4)
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	@Column(name = "CREATE_DATE", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
