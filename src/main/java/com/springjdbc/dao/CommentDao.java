package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Comment;
import com.springjdbc.entity.Post;

public interface CommentDao 
{
	public int addComment(Comment comment);
	public int editComment(int commentId, String comment_content);
	public int deleteComment(int commentId);
	public List<Comment> getAllComments(int post_id);
}
