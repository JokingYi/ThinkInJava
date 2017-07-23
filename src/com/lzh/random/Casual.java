package com.lzh.random;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lzh.innerClass.NestedClass;
import com.lzh.innerClass.NestedClass.InClass;
import com.lzh.innerClass.NestedClass.InClass2;

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
//		long diff=3l-4l;
//		System.out.println(diff);
		
		/*
		int i=Integer.MIN_VALUE;
		
//		InClass2 inClass2=new NestedClass().new InClass2();
		InClass inClass=new InClass();
		System.out.println(inClass);
		*/
//		Casual casual=new Casual();
//		System.out.println(casual.aboutException());
		
//		List<String> strings=new ArrayList<>();
//		strings.add("1");
//		strings.add("2");
		//start with 0
//		System.out.println(strings.get(0));
		
//		System.out.println("test".substring(0, 2));
		
//		System.out.println("make some casual changes");
		//注意，不是返回的不是接口类型
//		System.out.println(new Book().getClass().getName());
		/*
		for (int i = 0; i < 10; i++)
		{
//			System.out.println(randomNum(10));
			System.out.println(anotherRandom(10));
		}
		*/
	}
	
	public int aboutException()
	{
		
		try
		{
			String[] strings={"1", "2"};
			System.out.println(strings[4]);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return 1;
		
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
