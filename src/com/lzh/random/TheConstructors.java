package com.lzh.random;

class Super
{
	private int id;

	public Super(int id)
	{
		this.id = id;
	}
	public Super()
	{
	}
	public void print()
	{
		System.out.println("the method in super");
	}
}

class Base extends Super
{
	public void what()
	{
		super.print();
	}
	public void info()
	{
		System.out.println("something");
	}
}

public class TheConstructors
{
	public static void main(String[] args)
	{
		Super super1=new Base();
		Base base=(Base) super1;
		base.info();
		
		/*
		//can be compiled, but will throw an error
		Base base=(Base) new Super();
		base.what();
		*/
		//test super keyword
//		new Base().what();
	}
}
