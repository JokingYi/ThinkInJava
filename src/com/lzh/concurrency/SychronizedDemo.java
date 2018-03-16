package com.lzh.concurrency;

import java.util.concurrent.TimeUnit;

public class SychronizedDemo
{
	public static void main(String[] args)
	{
		SychronizedDemo demo=new SychronizedDemo();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				demo.normalMethod2s();
			}
		}).start();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				demo.syncOutMethod2s();
			}
		}).start();
	}
	public synchronized void syncOutMethod2s()
	{
		System.out.println("outer start");
		sleep(2);
		System.out.println("outer end");
	}
	
	public void normalMethod2s()
	{
		System.out.println("normal start..");
		sleep(2);
		System.out.println("normal end...");
	}
	public void syncInnerMethod2s()
	{
		synchronized(this)
		{
			System.out.println("inner start");
			sleep(2);
			System.out.println("inner end");
		}
	}
	public static void sleep(int secondes)
	{
		try
		{
			TimeUnit.SECONDS.sleep(secondes);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
