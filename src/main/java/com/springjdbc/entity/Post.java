package com.springjdbc.entity;

public class Post 
{
	private int id;
	private String post_title;
	private String post_content;
	private int author_id;
	
	public Post(int id, String post_title, String post_content, int author_id) {
		super();
		this.id = id;
		this.post_title = post_title;
		this.post_content = post_content;
		this.author_id = author_id;
	}
	public Post() {
		// TODO Auto-generated constructor stub
	}
	public void addPost(String post_title, String post_content, int author_id) {
		
		this.post_title = post_title;
		this.post_content = post_content;
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", post_title=" + post_title + ", post_content=" + post_content + ", author_id="
				+ author_id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	
}
