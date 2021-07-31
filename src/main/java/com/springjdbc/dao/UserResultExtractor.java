package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springjdbc.entity.User;

public class UserResultExtractor implements ResultSetExtractor<List<User>> {
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<User> userList=new ArrayList<User>();
		while(rs.next())
		{
			User student=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7));
			userList.add(student);
		}
		return userList;
	}
}
