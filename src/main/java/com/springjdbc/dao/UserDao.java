package com.springjdbc.dao;

import com.springjdbc.entity.User;

public interface UserDao 
{
	public User authentication(String userName, String password);
	public int registration(User user);
}
