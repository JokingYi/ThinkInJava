package com.lzh.concurrency;

class Task1 implements Runnable
{
	private static int count=0;
	private final int id=count++;
	public Task1()
	{
		System.out.println("in constructor");
	}

	@Override
	public void run()
	{
		System.out.println("message1 ID="+id);
		Thread.yield();
		System.out.println("message2 ID="+id);
		Thread.yield();
		System.out.println("message3 ID="+id);
		Thread.yield();
		System.out.println("terminated ID="+id);
	}
	
}

public class Exercise1
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 3; i++)
		{
			new Thread(new Task1()).start();
		}
	}
}
