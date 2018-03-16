package com.lzh.modifier;

class TestStatic
{
	public TestStatic()
	{
		System.out.println("in static field construtor");
	}
}
class TestStatic2
{
	public static String string="static";
	private static int id=0;
	static {
		System.out.println("------");
	}
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
		System.out.println("in the current object constructor");//forth
	}
	public static void main(String[] args)
	{
//		AboutStatic aboutStatic=new AboutStatic();
//		TestStatic2 static2=new TestStatic2();
//		static2.printId();
//		new TestStatic2().printId();
	}
	
	//its diff between the two way to get the reference of class object
	private static void testClassLiteral()
	{
		Class<?> class1= TestStatic2.class;
	}
	private static void testForName()
	{
		try
		{
			Class<?> testStaticClass=Class.forName("com.lzh.modifier.TestStatic2");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
