package com.lzh.modifier;

class OutClass
{
	static final int Num=1;
	static int test=2;
	static {
		System.out.println("initialized2");
	}
}

public class AboutStaticFinal
{
	//
	static final int NUM=1;
	static int test=2;
	//no matter what, if you started this main() method, 
	//it will be initialized!!
//	static
//	{
//		System.out.println("initialized1");
//	}
	public AboutStaticFinal()
	{
		System.out.println("in constructor");
	}
	public static void main(String[] args)
	{
		//both of them wont invoke the constructor
//		System.out.println(AboutStaticFinal.test);
//		System.out.println(AboutStaticFinal.class);
		
		//wont load the class
		System.out.println(AboutStaticFinal.NUM);
		
//		System.out.println(OutClass.Num);
//		System.out.println(OutClass.test);
	}
	private void testClassInitialization()
	{
		System.out.println(OutClass.Num);
		Class<?> class1=OutClass.class;
	}
}
