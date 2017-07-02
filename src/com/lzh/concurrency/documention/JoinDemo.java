package com.lzh.concurrency.documention;

public class JoinDemo
{
	private static class Task1 implements Runnable
	{

		@Override
		public void run()
		{
			for(int i=0; i<50; i++)
				System.out.println("attention, im joining");
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("before");
		Thread thread=new Thread(new Task1());
		thread.start();
		thread.join();
		System.out.println("end");
	}
}
