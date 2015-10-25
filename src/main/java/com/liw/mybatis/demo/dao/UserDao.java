package com.liw.mybatis.demo.dao;

import com.liw.mybatis.demo.po.User;
/**
 * 原始dao的demo
 * 
 */
public interface UserDao {
	User findByUserId(int id) throws Exception;
	void insertUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	
}
