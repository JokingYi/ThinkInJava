package com.lzh.concurrency;

import java.util.HashMap;
import java.util.Map;

class UnsafeClass
{
	private boolean available=false;
	private Map<String, String> map=new HashMap<>();
	synchronized public void putString()
	{
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		available=true;
		notifyAll();
//		System.out.println("key value put!");
	}
	synchronized public void readString()
	{
		while(!available)
		{
			try
			{
//				System.out.println("waiting...");
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
//		System.out.println("gocha!");
//		System.out.println("the value is: "+map.get("key1"));
		if (map.get("key1")==null)
		{
			System.out.println("error");
		}
	}
}

public class FieldVisibility
{
	public static void main(String[] args)
	{
		//none!!!
		for(int i=0;i<300;i++)
		{
			UnsafeClass unsafeClass=new UnsafeClass();
			//times are, when the value is put, but still the other thread can
			//not read the value, thus, "the value is null"
			//
			//the "order" problem is well solved, but the visibility is still in a unstable situation
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					unsafeClass.readString();
				}
			}).start();
			new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					unsafeClass.putString();
				}
			}).start();
		}
		
	}
}
