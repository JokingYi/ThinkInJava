package com.lzh.concurrency.gaohongyan;

class SynObject
{
	 synchronized public static void print()
	{
		 System.out.println("begin");
		if (Thread.currentThread().getName().equals("a"))
		{
			System.out.println("the method will not be invoked");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}
}

public class ThreadResume
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread1=new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				SynObject.print();
			}
		});
		thread1.setName("a");
		thread1.start();
		System.out.println("thread1 started");
		Thread.sleep(100);
		Thread thread2=new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				SynObject.print();
			}
		});
		thread2.setName("b");
		thread2.start();//没有再次进入方法
		System.out.println("thread2 started");
	}
}
