package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Post;

public interface PostDao 
{
	public List<Post> getAllPosts(int author_id);
	public Post getPost(int postId);
	public int addPost(Post post);
	public int editPost(Post post);
	public int deletePost(int postId, int author_id);
}
