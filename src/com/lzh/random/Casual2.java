package com.lzh.random;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

class M
{
	//cant extends this class
	private M()
	{
	}
}

public class Casual2
{
	public static void main(String[] args)
	{
		Set<String> set;
		
		/*
		List<List<String>> container=new ArrayList<>();
		List<String> items=new ArrayList<>();
		for (int i = 0; i < 4; i++)
		{
			items.clear();
			items.add("1");
			items.add("2");
			container.add(items);
		}
		System.out.println(container);
		container.get(0).add("3");
		//因为添加的指向items的指针，所以改动其中一个，就会改动其他
		//so its needed to shift the "items" into the for block
		System.out.println(container);
		*/
		//cost 2 bytes(16 bits)
		char one='a';
		
		//about Random
//		Random random1=new Random(33);
//		Random random2=new Random(33);
//		//输出相同
//		System.out.println(random1.nextInt(10));
//		System.out.println(random2.nextInt(10));
	}
}
