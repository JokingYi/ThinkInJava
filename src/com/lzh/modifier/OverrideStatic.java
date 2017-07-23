package com.lzh.modifier;

public class OverrideStatic
{
	private static class Parent
	{
		public static void print()
		{
			System.out.println("static method in parent");
		}
		public void test()
		{
			
		}
	}
	private static class Child extends Parent
	{
		//cannot override print()
	}
}
