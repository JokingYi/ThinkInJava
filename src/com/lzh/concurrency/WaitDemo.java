package com.lzh.concurrency;

public class WaitDemo
{
	private static class Task
	{
		public synchronized void work1()
		{
			System.out.println("work1 started");
			try
			{
				wait(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("work1 finished");
		}
		public synchronized void work2()
		{
			System.out.println("work2 started");
			System.out.println("work2 finished");
		}
	}
	public static void main(String[] args)
	{
		Task task=new Task();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				task.work1();
			}
		}).start();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				task.work2();
			}
		}).start();
	}
}
