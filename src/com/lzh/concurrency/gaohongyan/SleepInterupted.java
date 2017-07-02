package com.lzh.concurrency.gaohongyan;

import java.util.concurrent.TimeUnit;

class LongThread implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("run started");
		try
		{
			TimeUnit.SECONDS.sleep(10);
			System.out.println("run ended");
		} catch (InterruptedException e)
		{
			System.out.println("sleep being interupted");
			e.printStackTrace();
		}
		
	}
	
}

public class SleepInterupted
{
	public static void main(String[] args)
	{
		Thread thread=new Thread(new LongThread());
		thread.start();
		try
		{
			Thread.sleep(100);
			thread.interrupt();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
