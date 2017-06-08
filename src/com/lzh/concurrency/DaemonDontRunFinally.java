package com.lzh.concurrency;

import java.util.concurrent.ThreadFactory;

class DaemonThreadFactory implements ThreadFactory
{

	@Override
	public Thread newThread(Runnable r)
	{
		Thread thread=new Thread(r);
		thread.setDaemon(true);
		return thread;
	}
	
}

public class DaemonDontRunFinally implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			System.out.println("Running...");
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally 
		{
			System.out.println("if the finally clause will be executed?");
		}
		
	}
	public static void main(String[] args) throws InterruptedException
	{
		
//		ExecutorService service=Executors.newSingleThreadExecutor(new DaemonThreadFactory());
//		service.execute(new DaemonDontRunFinally());
//		System.out.println("thread started");
		
		Thread thread=new Thread(new DaemonDontRunFinally());
		thread.setDaemon(true);
		thread.start();
		
	}
}
