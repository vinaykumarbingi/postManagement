package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springjdbc.entity.Post;

public class PostResultExtractor implements ResultSetExtractor {

	@Override
	public List<Post> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Post> postList=new ArrayList<Post>();
		while(rs.next())
		{
			Post post=new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			postList.add(post);
		}
		return postList;
		
	}

}
