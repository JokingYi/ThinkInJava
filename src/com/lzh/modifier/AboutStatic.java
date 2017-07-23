package com.lzh.modifier;

class TestStatic
{
	public TestStatic()
	{
		System.out.println("in field construtor");
	}
}
class TestStatic2
{
	private static int id=0;
	public TestStatic2()
	{
		id++;
		System.out.println("normal field constructor");
	}
	public void printId()
	{
		System.out.println("#"+id);
	}
}
public class AboutStatic
{
	private TestStatic2 testStatic=new TestStatic2();//third
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
		
//		TestStatic2 static2=new TestStatic2();
//		static2.printId();
//		new TestStatic2().printId();
	}
}
