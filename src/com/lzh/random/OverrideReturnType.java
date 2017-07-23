package com.lzh.random;

class Sup1
{
	public int print()
	{
		return 1;
	}
	
	public Object testReturnObject()
	{
		return new Object();
	}
	public Sup1 self()
	{
		return new Sup1();
	}
}

class Base1 extends Sup1
{
	//毫无波动。。。
	@Override
	public Base1 testReturnObject()
	{
		System.out.println("in base");
		return new Base1();
	}
	@Override
	public Base1 self()
	{
		return new Base1();
	}
	//编译不通过。
//	public byte print()
//	{
//		return 2;
//	}
	
}

public class OverrideReturnType
{
	public static void main(String[] args)
	{
//		int i=(int) 10l;
//		byte b=3;
//		int j=b;
		//		new Base1().testReturnObject();
		
		//return the direct parent
		System.out.println(Base1.class.getSuperclass().getName());
	}
}
