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

import com.liw.mybatis.demo.po.Items;
import com.liw.mybatis.demo.po.ItemsExample;
import com.liw.mybatis.demo.po.ItemsExample.Criteria;

public class ItemsMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource="SqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Test
	public void testSelectByExampleWithBLOBs() {
		SqlSession session = sqlSessionFactory.openSession();
		ItemsMapper mapper = session.getMapper(ItemsMapper.class);
		ItemsExample e=new ItemsExample();
		Criteria criteria = e.createCriteria();
		criteria.andNameLike("%prod%");
		List<Items> items = mapper.selectByExampleWithBLOBs(e);
		System.out.println(items);
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

}
