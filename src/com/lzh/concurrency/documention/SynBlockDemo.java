package com.lzh.concurrency.documention;

import java.util.concurrent.TimeUnit;

public class SynBlockDemo
{
	public static void main(String[] args)
	{
		new Thread(new Task1()).start();
		new Thread(new Task2()).start();
	}
	private static class Task1 implements Runnable
	{

		@Override
		public void run()
		{
			synchronized (SynBlockDemo.class)
			{
				System.out.println("Task1 started");
				System.out.println("task1 is sleeping");
				
				try
				{
					TimeUnit.SECONDS.sleep(3);
					System.out.println("task1 is waiting");
					SynBlockDemo.class.wait();
//					wait(0);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("task1 is over");
			}
		}
	}
	private static class Task2 implements Runnable
	{
		@Override
		public void run()
		{
			synchronized (SynBlockDemo.class)
			{
				System.out.println("task2 started");
				System.out.println("task2 is sleeping");
				SynBlockDemo.class.notify();
				try
				{
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("task2 is over");
			}
			
		}
		
	}
}
