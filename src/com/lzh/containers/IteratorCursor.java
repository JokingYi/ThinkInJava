package com.lzh.containers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorCursor
{
	public static void main(String[] args)
	{
		Set<Integer> nums=new HashSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		Iterator<Integer> iterator=nums.iterator();
		boolean flag=true;
		while (iterator.hasNext())
		{
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			if(flag)
			{
				flag=false;
				iterator.remove();
			}
			
		}

		System.out.println("-----");
		System.out.println("after that ");
		System.out.println(nums);
	}

}
