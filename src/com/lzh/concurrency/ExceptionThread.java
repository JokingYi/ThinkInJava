package com.lzh.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable
{

	@Override
	public void run()
	{
		throw new RuntimeException("for test");
	}
	public static void main(String[] args)
	{
		ExecutorService service=Executors.newCachedThreadPool();
		try
		{
			service.execute(new ExceptionThread());
		} catch (RuntimeException e)
		{
			//this statement will not be executed!
			System.out.println("if the exception will be catched");
			e.printStackTrace();
		}
	}
}
