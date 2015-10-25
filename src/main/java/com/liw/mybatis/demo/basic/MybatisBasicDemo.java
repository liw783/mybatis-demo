package com.liw.mybatis.demo.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liw.mybatis.demo.po.User;

public class MybatisBasicDemo {
	//单条查询
	public void findByUserId() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//参数1：映射文件中statement的id,等于namespace+"."+statment的id
		//selectOne不能用在返回多条的情况下
		User user=sqlSession.selectOne("test.findUserById",1);
		System.out.println(user);
		
		sqlSession.close();
		 
	}
	
	//模糊查询
	public void findByUserName() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users=sqlSession.selectList("test.findUserByName","l");
		for(User u:users){
			System.out.println(u);
		}
		sqlSession.close();
		 
	}
	
	//插入
	public void insertUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user=new User();
		user.setAddress("河南");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("王小五");
		sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();
		 
	}
	
	//删除
	public void deleteUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",10);
		sqlSession.commit();
		
		sqlSession.close();
		 
	}
	
	//更新
	public void updateUser() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user=new User();
		user.setId(9);
		user.setBirthday(new Date());
		user.setAddress("河南");
		user.setUsername("王小七");
		user.setSex("1");
		sqlSession.update("test.updateUser",user);
		sqlSession.commit();
		
		sqlSession.close();
		 
	}
	
	public static void main(String[] args) throws IOException {
		MybatisBasicDemo demo=new MybatisBasicDemo();
		demo.updateUser();
	}
}
