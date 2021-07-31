package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = "com.springjdbc")
public class AppConfig 
{
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource conf=new DriverManagerDataSource();
		conf.setDriverClassName("com.mysql.cj.jdbc.Driver");
		conf.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		conf.setUsername("root");
		conf.setPassword("1234");
		return conf;
	}
	
	@Bean
	public JdbcTemplate getConnection()
	{
		JdbcTemplate connection=new JdbcTemplate();
		connection.setDataSource(getDataSource());
		return connection;
	}
	
//	@Bean
//	public NamedParameterJdbcTemplate getConnection()
//	{
//		NamedParameterJdbcTemplate connection=new NamedParameterJdbcTemplate(getDataSource());
//		return connection;
//	}
}
