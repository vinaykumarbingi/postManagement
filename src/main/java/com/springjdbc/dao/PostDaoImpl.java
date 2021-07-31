package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Post;

@Component
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Post> getAllPosts(int author_id) {
		String query="select * from post where author_id=?";
		return jdbcTemplate.query(query, new PostResultExtractor(), author_id);
		
	}

	@Override
	public Post getPost(int postId) {
		String query="select * from post where id=?";
		return jdbcTemplate.queryForObject(query, new PostRowMapperImpl(), postId);
		
	}

	@Override
	public int addPost(Post post) {
		String query="insert into post (post_title, post_content, author_id) values (?,?,?) ";
		return jdbcTemplate.update(query, post.getPost_title(), post.getPost_content(), post.getAuthor_id());
		
	}

	@Override
	public int editPost(Post post) {
		 String query = "update post set post_title=? , post_content=? where id=? and author_id=?"; 
                 
         return jdbcTemplate.update(query, post.getPost_title(),post.getPost_content(), post.getId(), post.getAuthor_id());
		
	}

	@Override
	public int deletePost(int postId, int author_id) {
		String query="delete from post where id=? and author_id=?";
		return jdbcTemplate.update(query, postId, author_id);
	}

}
