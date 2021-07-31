package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.Post;

public class PostRowMapperImpl implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post=new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		return post;
	}

}
