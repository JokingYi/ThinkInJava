package com.lzh.random;

public class StackoverFlowErrorDemo
{
	public static void main(String[] args)
	{
		try
		{
			loop();
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
	public static void loop()
	{
		while(true)
		{
			String string =new String();
			string.length();
		}
	}
}
