package com.lzh.concurrency.documention;

import java.util.concurrent.TimeUnit;

public class SynMethod
{
	private static class SynNum
	{
		private int num=0;
		synchronized public static void print()
		{
			//yes
			//for the lock is corresponding to the Class Object whick is diff from
			//the object instance
			System.out.println("test if the static method use diff lock");
		}
		synchronized public void increment()
		{
			try
			{
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			num++;
			System.out.println("add");
			System.out.println(this.value());
		}
		synchronized public void decrement()
		{
			try
			{
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			num--;
			System.out.println("decrement");
			System.out.println(this.value());
		}
		synchronized public int value()
		{
			return num;
		}
	}
	private static class NumAddTask implements Runnable
	{
		private SynNum num;
		public NumAddTask(SynNum num)
		{
			super();
			this.num = num;
		}
		@Override
		public void run()
		{
			num.increment();
//			System.out.println(num.value());
		}
	}
	private static class NumDeTask implements Runnable
	{
		private SynNum num;
		public NumDeTask(SynNum num)
		{
			super();
			this.num = num;
		}

		@Override
		public void run()
		{
			num.decrement();
//			System.out.println(num.value());
		}
		
	}
	private static class PrintTask implements Runnable
	{
		private SynNum num;
		
		public PrintTask(SynNum num)
		{
			super();
			this.num = num;
		}
		@Override
		public void run()
		{
			num.print();
		}
		
	}
	public static void main(String[] args)
	{
		SynNum num=new SynNum();
		Thread thread=new Thread(new NumAddTask(num));
		Thread thread2=new Thread( new NumDeTask(num));
		Thread thread3=new Thread(new PrintTask(num));
		thread.start();
		thread2.start();
		thread3.start();
	}
}
