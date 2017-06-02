package com.lzh.algorithm;

import java.util.Arrays;

public class ReverseArray
{
	public static void reverse(Object[] objects)
	{
		Object temp=null;
		int length=objects.length;
		for(int i=0; i<length/2; i++)
		{
			temp=objects[length-1-i];
			objects[length-1-i]=objects[i];
			objects[i]=temp;
		}
	}
	
	public static void main(String[] args)
	{
		String[] strings={"1", "2", "3", "4"};
		ReverseArray.reverse(strings);
		System.out.println(Arrays.asList(strings));
 	}
}
