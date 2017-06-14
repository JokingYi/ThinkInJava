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
}

public class TheConstructors
{
	public static void main(String[] args)
	{
		//test super keyword
		new Base().what();
	}
}
