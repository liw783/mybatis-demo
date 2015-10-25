package com.liw.mybatis.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liw.mybatis.demo.po.User;
/**
 * 原始dao的demo
 * 
 */
public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}

	public User findByUserId(int id) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		session.close();
		return user;
	}

	public void insertUser(User user) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		session.commit();
		session.close();

	}

	public void deleteUser(int id) throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		session.delete("test.deleteUser", id);
		session.commit();
		session.close();

	}

}
