package com.lzh.concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonThread implements Runnable
{
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		for(int i=0; i<10; i++)
		{
			Thread daemon=new Thread(new DaemonThread());
			//daemon thread is not essence part of the program
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all daemon started");
		try
		{
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
