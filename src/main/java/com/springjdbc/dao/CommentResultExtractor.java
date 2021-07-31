package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springjdbc.entity.Comment;
import com.springjdbc.entity.Post;

public class CommentResultExtractor implements ResultSetExtractor {

	@Override
	public List<Comment> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Comment> commentList=new ArrayList<Comment>();
		while(rs.next())
		{
			Comment comment=new Comment(rs.getInt(1), rs.getString(2),  rs.getInt(3));
			commentList.add(comment);
		}
		return commentList;
	}

}
