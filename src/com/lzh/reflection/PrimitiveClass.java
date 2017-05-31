package com.lzh.reflection;

import com.my.dynamicProxy.DirectImpl;

public class PrimitiveClass
{
	public static void main(String[] args)
	{
//		System.out.println(int.class.getName());//Êä³ö£ºint
		for (int i = 0; i < DirectImpl.class.getInterfaces().length; i++)
		{
			System.out.println(DirectImpl.class.getInterfaces()[i].getName());
		}
	}
}
