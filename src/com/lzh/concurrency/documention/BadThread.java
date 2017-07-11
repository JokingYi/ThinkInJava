package com.lzh.concurrency.documention;

public class BadThread
{
	private static String message;
	private static class CorrectorThread extends Thread
	{
		@Override
		public void run()
		{
			try
			{
				sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			message="do eat";
		}
	}
	public static void main(String[] args)
	{
		new Thread(new CorrectorThread()).start();
		message="do not eat";
		try
		{
			Thread.sleep(200);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(message);
	}
}
