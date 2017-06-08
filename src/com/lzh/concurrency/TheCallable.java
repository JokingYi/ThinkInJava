package com.lzh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String>
{
	private static int count=0;
	private final int id=count++;
	public TaskWithResult()
	{
	}

	@Override
	public String call() throws Exception
	{
//		Thread.sleep(1000);
//		if (id==5)
//		{
//			int a[]={1,2};
//			System.out.println(a[6]);
//		}
		//do something 
		return "result"+id;
	}
	
}

public class TheCallable
{
	
	public static void main(String[] args)
	{
		ExecutorService service=Executors.newCachedThreadPool();
		List<Future<String>> futures=new ArrayList<>(6);
//		System.out.println(futures.size());//0
		
		for (int i = 0; i <6; i++)
		{
			futures.add(service.submit(new TaskWithResult()));
		}
		for (Future<String> future : futures)
		{
			try
			{
				System.out.println(future.get());
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			} catch (ExecutionException e)
			{
				e.printStackTrace();
			}finally {
				service.shutdown();
			}
		}
	}
}
