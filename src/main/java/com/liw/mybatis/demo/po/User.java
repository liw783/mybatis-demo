package com.liw.mybatis.demo.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 */
public class User implements Serializable{
	private int id;
	private String username;
	private String sex;
	private Date birthday; 
	private String address;
	private List<Orders> ordersList;
	public int getId() {
		return id;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return this.id+" "+this.username+" "+this.address+" "+this.birthday;
	}
}