package com.lzh.stackoverflow;

public class AssignNull
{
	public static void main(String[] args)
	{
		String a="1", b="2", c="3";
		String[] strings={a,b,c};
//		c=null;
		c="4";
		
		for (String string : strings)
		{
			System.out.println(string);
		}
	}
}
