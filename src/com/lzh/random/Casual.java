package com.lzh.random;

import java.util.Random;

interface Packable
{
	void print();
}

class Book implements Packable
{

	@Override
	public void print()
	{
	}
	
}

public class Casual
{
	public static void main(String[] args)
	{
		System.out.println("comments do not count?");
//		System.out.println("make some casual changes");
		//ע�⣬���Ƿ��صĲ��ǽӿ�����
		System.out.println(new Book().getClass().getName());
		/*
		for (int i = 0; i < 10; i++)
		{
//			System.out.println(randomNum(10));
			System.out.println(anotherRandom(10));
		}
		*/
	}
	
	public static int randomNum(int range)
	{
		return (int) (Math.random()*range);
	}
	public static int anotherRandom(int range)
	{
		int num=new Random().nextInt(range);
		return num;
	}
}
