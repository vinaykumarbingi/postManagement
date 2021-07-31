package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Comment;

@Component
public class CommentDaoImpl implements CommentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int addComment(Comment comment) {
		String query="insert into comment (comment_content, post_id) values (?,?) ";
		return jdbcTemplate.update(query, comment.getComment_content(), comment.getPost_id());
		
	}

	@Override
	public int editComment(int commentId, String comment_content) {
		String query = "update comment set comment_content=?  where id=?"; 
        return jdbcTemplate.update(query, comment_content, commentId );
		
	}

	@Override
	public int deleteComment(int commentId) {
		String query="delete from comment where id=?";
		return jdbcTemplate.update(query, commentId);
		
	}

	@Override
	public List<Comment> getAllComments(int post_id) {
		String query="select * from comment where post_id=?";
		return jdbcTemplate.query(query, new CommentResultExtractor(), post_id);
		
	}

}
