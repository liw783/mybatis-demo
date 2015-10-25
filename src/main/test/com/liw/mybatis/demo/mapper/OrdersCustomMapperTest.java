package com.liw.mybatis.demo.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.liw.mybatis.demo.po.Orders;
import com.liw.mybatis.demo.po.OrdersCustom;
import com.liw.mybatis.demo.po.User;

public class OrdersCustomMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		this.sqlSessionFactory=sqlSessionFactory;
	}

//	@Test
//	public void testFindOrdersUser() throws Exception{
//		SqlSession session=sqlSessionFactory.openSession();
//		OrdersCustomMapper mapper = session.getMapper(OrdersCustomMapper.class);
//		List<OrdersCustom> orders = mapper.findOrdersList();
//		for(OrdersCustom o:orders){
//			System.out.println(o.getUsername()+" "+o.getSex()+" "+o.getAddress());
//		}
//		session.close();
//	}
	
//	@Test
//	public void testFindOrdersUserResultMap() throws Exception{
//		SqlSession session=sqlSessionFactory.openSession();
//		OrdersCustomMapper mapper = session.getMapper(OrdersCustomMapper.class);
//		List<Orders> orders = mapper.findOrdersListResultMap();
//		for(Orders o:orders){
//			System.out.println(o.getUser().getUsername()+" "+o.getUser().getSex()+" "+o.getUser().getAddress());
//		}
//		session.close();
//	}
	
//	@Test
//	public void testFindOrdersDetailListResultMap() throws Exception{
//		SqlSession session=sqlSessionFactory.openSession();
//		OrdersCustomMapper mapper = session.getMapper(OrdersCustomMapper.class);
//		List<Orders> orders = mapper.findOrdersDetailListResultMap();
//		for(Orders o:orders){
//			System.out.println(o.getUser().getUsername()+" "+o.getUser().getSex()+" "+o.getUser().getAddress());
//		}
//		session.close();
//	}
//	@Test
//	public void testFindUserItemsResultMap() throws Exception{
//		SqlSession session=sqlSessionFactory.openSession();
//		OrdersCustomMapper mapper = session.getMapper(OrdersCustomMapper.class);
//		List<User> users = mapper.findUserItemsResultMap();
//		for(User o:users){
//			System.out.println(o.toString());
//		}
//		//一级缓存测试
//		List<User> users2 = mapper.findUserItemsResultMap();
//		for(User o:users2){
//			System.out.println(o.toString());
//		}
//		session.close();
//	}
	//二级缓存测试
	@Test
	public void testCache() throws Exception{
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u1 = mapper.findUserById(1);
		session.close();
		
		session=sqlSessionFactory.openSession();
		mapper = session.getMapper(UserMapper.class);
		User u2 = mapper.findUserById(1);
		session.close();
	}
}
