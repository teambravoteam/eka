package com.varxyz.eka.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@ComponentScan(basePackages="com.varxyz.eka")
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/eka?serverTimezone=Asia/Seoul");
		ds.setUsername("eka");
		ds.setPassword("eka");
		ds.setInitialSize(2); 	
		ds.setMaxActive(10);  	
		ds.setMaxIdle(10); 	
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() { 
		return new JdbcTemplate(dataSource()); 
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	
	
}
