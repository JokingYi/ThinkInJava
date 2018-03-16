package com.lzh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ListSizeDemo
{
	public static void main(String[] args)
	{
		testSyncConcurrentVector();
	}
	public static void testSyncConcurrentVector()
	{
		final List<Integer> nums=new Vector<>();
		for (int i = 0; i < 3; i++)
			nums.add(i);
		new Thread(new SyncPrintTask(nums)).start();
		new Thread(new SyncRemoveTask(nums, 0)).start();
	}
	public static void testConcurrentList()
	{
		final List<Integer> nums=new ArrayList<>();
		for (int i = 0; i < 3; i++)
			nums.add(i);
		new Thread(new PrintTask(nums)).start();
		new Thread(new RemoveTask(nums, 0)).start();
	}
	public static void testConcurrentVector()
	{
		final List<Integer> nums=new Vector<>();
		for (int i = 0; i < 3; i++)
			nums.add(i);
		new Thread(new PrintTask(nums)).start();
		new Thread(new RemoveTask(nums, 0)).start();
	}
	public static void sleep(int seconds)
	{
		try
		{
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	private static class SyncRemoveTask implements Runnable
	{
		private List<Integer> nums;
		private Integer index;
		public SyncRemoveTask(List<Integer> nums, Integer index)
		{
			this.nums=nums;
			this.index=index;
		}
		@Override
		public void run()
		{
			synchronized (nums)
			{
				sleep(1);
				nums.remove(index);
				System.out.println("remove completed...");
			}
		}
	}
	
	private static class SyncPrintTask implements Runnable 
	{
		private List<Integer> nums;
		public SyncPrintTask(List<Integer> nums)
		{
			this.nums=nums;
		}
		@Override
		public void run()
		{
			Object[] temp=null;
			synchronized (nums)
			{
				sleep(1);
				temp=nums.toArray();
				System.out.println("transfer completed...");
			}
			for (int i = 0; i < temp.length; i++)
			{
				sleep(1);
				System.out.println((Integer)temp[i]);
			}
			System.out.println("print completed...");
		}
		
	}
	private static class RemoveTask implements Runnable 
	{
		private List<Integer> nums;
		private Integer index;
		public RemoveTask(List<Integer> nums, Integer index)
		{
			this.nums=nums;
			this.index=index;
		}
		@Override
		public void run()
		{
			sleep(1);
			nums.remove(index);
			System.out.println("remove completed...");
		}
	}
	private static class PrintTask implements Runnable 
	{
		private List<Integer> nums;
		public PrintTask(List<Integer> nums)
		{
			this.nums=nums;
		}
		@Override
		public void run()
		{
			for (int i = 0; i < nums.size(); i++)
			{
				sleep(1);
				System.out.println(nums.get(i));
			}
			System.out.println("print completed...");
		}
	}
}
