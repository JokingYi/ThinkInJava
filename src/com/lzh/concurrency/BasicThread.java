package com.lzh.concurrency;

import java.util.concurrent.TimeUnit;

class RunDemo implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("sleeping");
		try
		{
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}finally
		{
			System.out.println("awaken");
		}
	}
	
}

public class BasicThread
{
	public static void main(String[] args)
	{
		Thread thread=new Thread(new RunDemo());
//		thread.run();//顺序执行
		thread.start();//由虚拟机调度执行，并发执行
		System.out.println("output in main");
	}
}
