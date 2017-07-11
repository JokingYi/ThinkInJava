package com.lzh.containers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AboutSet
{
	public static void main(String[] args)
	{
		Set<Integer> nums=new HashSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(8);
		Iterator<Integer> iter=nums.iterator();
//		iter.remove();
		iter.next();
		iter.remove();
		while (iter.hasNext())
		{
			Integer integer = (Integer) iter.next();
			System.out.println(integer);
		}
		
	}
}
