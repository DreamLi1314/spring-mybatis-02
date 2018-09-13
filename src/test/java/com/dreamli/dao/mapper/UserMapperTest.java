package com.dreamli.dao.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dreamli.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)//使用 Spring 提供的注解方式测试
@ContextConfiguration("classpath:applicationContext.xml")// 加载 spring 容器
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testFindUserById() throws Exception {
		int id = 10;
		User user = userMapper.findUserById(id);
		System.out.println(user);
		assertEquals(id, user.getId());
	}

}
