package com.lzh.containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class TheWeakMap
{
	public static void main(String[] args)
	{
		String a=new String("a");
		String b=new String("b");
		Map<String, String> weakMap=new WeakHashMap<>();
		weakMap=new HashMap<String, String>();
		weakMap.put(a, "aaa");
		weakMap.put(b, "bbb");
		
		a=null;
//		b=null;

		System.gc();
		Iterator<Entry<String, String>> iterator=weakMap.entrySet().iterator();
		while (iterator.hasNext())
		{
			Entry<String, String> entry=iterator.next();
			System.out.println("result: "+entry.getKey()+" "+entry.getValue());
		}
	}
}
