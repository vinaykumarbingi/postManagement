package com.springjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.User;


@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User authentication(String userName, String password){
		try {
		String query="select * from user where user_name=? and password=?";
		return jdbcTemplate.queryForObject(query, new UserRowMapperImpl(), userName, password);
		
		//return jdbcTemplate.query(query,user_name, password);
		}catch(Exception e) {System.out.println("please enter valid credentials!!");}
		return null;
	}

	@Override
	public int registration(User user) {
		//String query="insert into user(first_name,last_name,user_name,password,mobile_number, email_address) values(:first_name,:last_name,:user_name, :password, :mobile_number, :email_address)";
		
//		Map data=new HashMap();
//		data.put("first_name", user.getFirst_name());
//		data.put("last_name", user.getLast_name());
//		data.put("user_name", user.getUser_name());
//		data.put("password", user.getPassword());
//		data.put("mobile_number", user.getMobile_number());
//		data.put("email_address", user.getEmail_address());
		//return jdbcTemplate.update(query,data);
		String query="insert into user (first_name,last_name,user_name,password,mobile_number, email_address) values (?,?,?,?,?,?) ";
		return jdbcTemplate.update(query, user.getFirst_name(), user.getLast_name(), user.getUser_name(), user.getPassword(), user.getMobile_number(), user.getEmail_address());

	}

}
