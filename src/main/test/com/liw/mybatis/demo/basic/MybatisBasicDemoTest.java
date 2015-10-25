package com.liw.mybatis.demo.basic;

import java.io.IOException;

import org.junit.Test;

public class MybatisBasicDemoTest {

	@Test
	public void testFindByUserId() throws IOException {
		MybatisBasicDemo d=new MybatisBasicDemo();
		d.findByUserId();
	}

}
