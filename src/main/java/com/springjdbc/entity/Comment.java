package com.springjdbc.entity;

public class Comment 
{
	private int id;
	private String comment_content;
	private int post_id;
	
	public Comment(int id, String comment_content, int post_id) {
		super();
		this.id = id;
		this.comment_content = comment_content;
		this.post_id = post_id;
	}
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public void addComment(String comment_content, int post_id) {
		
		this.comment_content = comment_content;
		this.post_id = post_id;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment_content=" + comment_content + ", post_id=" + post_id + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	
}
