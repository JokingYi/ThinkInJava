package com.lzh.concurrency.gaohongyan;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginServlet
{
	private static String username;
	private static String password;
	synchronized public static void dopost(String user, String pass)
	{
		Objects.requireNonNull(user);
		Objects.requireNonNull(pass);
		username=user;
		if (username.equals("a"))
		{
			try
			{
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		password=pass;
		System.out.println("username: "+username+"; password: "+password);
	}
}
