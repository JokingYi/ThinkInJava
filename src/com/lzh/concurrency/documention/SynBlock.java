package com.lzh.concurrency.documention;

import java.util.concurrent.TimeUnit;

public class SynBlock
{
	private static class MsLunch
	{
		private long l1=0;
		private long l2=0;
		private Object lock1=new Object();
		private Object lock2=new Object();
		
		public void AddL1()
		{
			synchronized (lock1)
			{
				try
				{
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				l1++;
				System.out.println("one: "+l1);
			}
		}
		public void AddL2()
		{
			synchronized (lock2)
			{
				try
				{
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				l2++;
				System.out.println("two: "+l2);
			}
		}
	}
	
	public static void main(String[] args)
	{
		MsLunch lunch=new MsLunch();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				lunch.AddL1();
			}
		}).start();
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				lunch.AddL2();
			}
		}).start();
	}
}
