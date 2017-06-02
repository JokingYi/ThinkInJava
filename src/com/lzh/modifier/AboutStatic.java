package com.lzh.modifier;

class TestStatic
{
	public TestStatic()
	{
		System.out.println("in field construtor");
	}
}

public class AboutStatic
{
	private TestStatic testStatic=new TestStatic();//third
	private static TestStatic testStatic2=new TestStatic();//first one 
	static 
	{
		System.out.println("in static block");//second
	}
	public AboutStatic()
	{
		System.out.println("in constructor");//forth
	}
	public static void main(String[] args)
	{
		AboutStatic aboutStatic=new AboutStatic();
	}
}
