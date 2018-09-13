package com.dreamli.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//@Configuration
//@ComponentScan("com.dreamli.*")
// 使用事务驱动管理器
//@EnableTransactionManagement
public class JavaTXConfig implements TransactionManagementConfigurer {

	// 数据源
	private DataSource dataSource;
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() throws Exception {
		if(dataSource != null) {
			return dataSource;
		}
		
		Properties staticProps = new Properties();
		Properties props = new Properties();
		System.out.println(new File(".").getAbsolutePath());
		staticProps.load(new FileInputStream("./src/main/resources/db.properties"));
		
		props.setProperty("driverClassName", staticProps.getProperty("jdbc.driver"));
		props.setProperty("url", staticProps.getProperty("jdbc.url"));
		props.setProperty("username", staticProps.getProperty("jdbc.username"));
		props.setProperty("password", staticProps.getProperty("jdbc.password"));
		
		System.out.println(props);
		
		dataSource = BasicDataSourceFactory.createDataSource(props);
		
		return dataSource;
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJDBCTemplate() throws Exception {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		
		return jt;
	}
	
	@Override
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		
		try {
			dataSourceTransactionManager.setDataSource(getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSourceTransactionManager;
	}

}
