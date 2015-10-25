package com.liw.mybatis.demo.dao;

import static org.junit.Assert.fail;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.liw.mybatis.demo.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		this.sqlSessionFactory=sqlSessionFactory;
	}
	@Test
	public void testFindByUserId() throws Exception {
		UserDao ud=new UserDaoImpl(sqlSessionFactory);
		User user = ud.findByUserId(1);
		System.out.println(user);
	}

}
