package com.lzh.concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * somthing about the application of the keyword "final" in concurrency
 * you can compare this class to another class "FieldVisibility"
 * @author ASUS
 */
public class FinalAndMutiThread
{
	//the final reference are guaranteed to be at most as 
	//up to date as when the constructor exists
	private final Map<String, String> strings;
	public FinalAndMutiThread(Map<String, String> strings)
	{
		this.strings=strings;
	}
	
	public void putData()
	{
		strings.put("key1", "value1");
//		System.out.println("data added");
	}
	public void getData()
	{
//		System.out.println("the key1's counterpart is "+strings.get("key1"));
		//turns out if the time is long enough, the field value will be available
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if (strings.get("key1")==null)
		{
			System.out.println("error occur!");
		}
	}
	
	public static void main(String[] args)
	{
		//repeat,repeat, repeat!that's what the computer do!
		for(int i=0;i<30;i++)
		{
			FinalAndMutiThread test=new FinalAndMutiThread(new HashMap<String, String>());
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					test.putData();
				}
			}).start();
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					test.getData();
				}
			}).start();
		}
	}
}
