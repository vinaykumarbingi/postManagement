package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.User;

public class UserRowMapperImpl implements RowMapper<User>{

	

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	User user=new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getString(7));
		return user;
	}

}
