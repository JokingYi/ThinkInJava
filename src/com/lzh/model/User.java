package com.lzh.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User
{
	private int id;
	private String userName;
	private String password;
	private Date birth;
	
	public User()
	{
	}
	
	public User(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "user info: "+userName+" "+password+" "+birth;
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getBirth()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birth);
	}
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	
}
