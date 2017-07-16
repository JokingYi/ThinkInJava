package com.lzh.concurrency.documention;

public class MessageLoop
{
	/**
	 * message about the current thread
	 * @param message
	 */
	public static void threadMessage(String message)
	{
		String threadName=Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	private static class Loop implements Runnable
	{

		@Override
		public void run()
		{
			String[] strings={
					"1", "2", "3", "4", "5", "6"
			};
			Thread thread=Thread.currentThread();
			for (int i = 0; i < strings.length && !thread.isInterrupted(); i++)
			{
				threadMessage(strings[i]);
				try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
					System.out.println("i wasnt done!");
					return;
					//or throw a exception
				}
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException
	{
		long patience=1000*3*4;
		threadMessage("starting main thread");
		Thread thread=new Thread(new Loop());
		long startTime=System.currentTimeMillis();
		thread.setName("loop");
		thread.start();
		
		threadMessage("wating for the loop thread to stop");
		while (thread.isAlive())
		{
			threadMessage("still waiting");
			thread.join(3000);
			if (System.currentTimeMillis()-startTime>patience && thread.isAlive())
			{
				threadMessage("long enough, time to stop");
				thread.interrupt();
			}
		}
		threadMessage("finally!");
	}
}
