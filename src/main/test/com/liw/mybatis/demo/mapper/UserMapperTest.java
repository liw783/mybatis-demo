package com.liw.mybatis.demo.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.liw.mybatis.demo.po.User;
import com.liw.mybatis.demo.po.UserCustom;
import com.liw.mybatis.demo.po.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		this.sqlSessionFactory=sqlSessionFactory;
	}

//	@Test
//	public void testFindByUserId() throws Exception {
//		SqlSession session=sqlSessionFactory.openSession();
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		User user = mapper.findUserById(1);
//		session.close();
//		System.out.println(user);
//	}
	
//	@Test
//	public void testFindUserList() throws Exception {
//		SqlSession session=sqlSessionFactory.openSession();
//		UserMapper mapper = session.getMapper(UserMapper.class);
//		UserCustom uc=new UserCustom();
//		uc.setSex("1");
//		uc.setUsername("小");
//		UserQueryVo vo=new UserQueryVo();
//		vo.setUserCustom(uc);
//		List<UserCustom> users = mapper.findUserList(vo);
//		session.close();
//		for(User u:users){
//			System.out.println(u);
//		}
//		
//	}
	
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserCustom uc=new UserCustom();
		uc.setSex("1");
		uc.setUsername("小");
		UserQueryVo vo=new UserQueryVo();
		vo.setUserCustom(uc);
		int count = mapper.findUserCount(vo);
		session.close();
		System.out.println(count);
		
	}
	
	@Test
	public void testFindUserList() throws Exception {
		SqlSession session=sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserCustom uc=new UserCustom();
		uc.setSex("1");
		uc.setUsername("小");
		UserQueryVo vo=new UserQueryVo();
		vo.setUserCustom(uc);
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(7);
		ids.add(9);
		vo.setIds(ids);
		List<UserCustom> users = mapper.findUserListResultMap(vo);
		session.close();
		for(User u:users){
			System.out.println(u);
		}
		
	}

}
