package com.lzh.enums;

enum Rain{MIN, MIDIUM, MAX};

/**
 * simplest usage of enum
 * @author ASUS
 *
 */
public class EnumClass
{
	public static void main(String[] args)
	{
		for (Rain rain : Rain.values())
		{
			System.out.println(rain.ordinal());//0£¬ 1£¬ 2
			System.out.println(rain.getClass().getSuperclass());//Enum
			System.out.println(rain.name());//MIN...
		}
		System.out.println("----------");
		System.out.println(String.class.getSuperclass());
	}
	
}
