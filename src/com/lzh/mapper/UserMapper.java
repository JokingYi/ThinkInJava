package com.lzh.mapper;

import java.util.List;

import com.lzh.model.User;

public interface UserMapper
{
	User selectUser(int id);
	void insertUser(User user);
	void insertTest(User user);
	void insertList(List<User> users);
}
