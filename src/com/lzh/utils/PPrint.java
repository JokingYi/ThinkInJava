package com.lzh.utils;

import java.util.Arrays;
import java.util.Collection;

public class PPrint
{
	private PPrint() throws Exception
	{
		throw new Exception("this class is not supposed to be instantialized");
	}
	public static String pformat(Collection<?> c)
	{
		if (c.size()==0) return "[]";
		StringBuilder result=new StringBuilder("[");
		for (Object object : c)
		{
			if(c.size()!=1)
				result.append("\n");
			result.append(object);
		}
		if(c.size()!=0)
			result.append("\n");
		result.append("]");
		return result.toString();
	}
	
	public static void pprint(Object[] objects) 
	{
		System.out.println(pformat(Arrays.asList(objects)));
	}
	
	public static void pprint(Collection<?> c)
	{
		System.out.println(pformat(c));
	}
	
	public static void main(String[] args)
	{
		String[] strings={"1", "2", "3"};
//		System.out.println(PPrint.pformat(Arrays.asList(1,3, 4)));
		System.out.println(PPrint.pformat(Arrays.asList(strings)));
	}
}
