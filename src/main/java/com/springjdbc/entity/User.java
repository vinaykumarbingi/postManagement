package com.springjdbc.entity;

public class User 
{
	private int id;
	private String first_name;
	private String last_name;
	private String user_name;
	private String password;
	private long mobile_number;
	private String email_address;
	
	public void register(String first_name, String last_name, String user_name, String password, long mobile_number,
			String email_address) {
		//super();
		//this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.password = password;
		this.mobile_number = mobile_number;
		this.email_address = email_address;
	}
	
	
	public User(int id, String first_name, String last_name, String user_name, String password, long mobile_number,
			String email_address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.password = password;
		this.mobile_number = mobile_number;
		this.email_address = email_address;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", user_name=" + user_name
				+ ", password=" + password + ", mobile_number=" + mobile_number + ", email_address=" + email_address
				+ "]";
	}
}
