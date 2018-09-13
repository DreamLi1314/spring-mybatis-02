package com.dreamli.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.dreamli.config.JavaTXConfig;

/**
 * @Description: 测试编程式事务管理----Java 配置方式需要开启 JavaTXConfig 配置 Configuration
 * @Warning: 
 * @Author: dreamli
 * @Package: spring-mybatis-02 - com.dreamli.dao.mapper.JavaTXTest.java
 * @Date: Sep 14, 2018 7:10:14 AM
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JavaTXConfig.class)
public class JavaTXTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Test
	public void testTransaction() {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
		
		try {
			jdbcTemplate.update("update user set sex = 1 where id = ?", 10);
			
//			int x = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		
		transactionManager.commit(status);
	}
	
}
