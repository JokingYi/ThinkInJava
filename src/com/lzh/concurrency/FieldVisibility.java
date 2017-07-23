package com.lzh.concurrency;

import java.util.HashMap;
import java.util.Map;

class UnsafeClass
{
	private Map<String, String> map=new HashMap<>();
	public void putString()
	{
		map.put("key1", "value1");
		map.put("key2", "value2");
		System.out.println("key value put!");
	}
	public void readString()
	{
		System.out.println("the value is: "+map.get("key1"));
	}
}

public class FieldVisibility
{
	public static void main(String[] args)
	{
		UnsafeClass unsafeClass=new UnsafeClass();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				unsafeClass.putString();
			}
		}).start();
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				unsafeClass.readString();;
			}
		}).start();
	}
}
