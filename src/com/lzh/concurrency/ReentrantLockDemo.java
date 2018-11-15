package com.lzh.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo
{
	ReentrantLock lock;
	public ReentrantLockDemo()
	{
		this.lock=new ReentrantLock();
	}
	public static void main(String[] args)
	{
		ReentrantLockDemo demo=new ReentrantLockDemo();
		demo.reentrant();
	}
	public void reentrant() {
		this.lock.lock();
		System.out.println("get lock once"+this.lock.getHoldCount());
		this.lock.lock();
		System.out.println("get lock twice"+this.lock.getHoldCount());
		this.lock.unlock();
		this.lock.unlock();
		System.out.println("released");
	}
	public void basic()
	{
		Executor executor=Executors.newFixedThreadPool(2);
		executor.execute(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("task1"+this);
				ReentrantLockDemo.this.lock.lock();
				System.out.println("task1 get lock");
				try
				{
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}finally {
					System.out.println("task1 completed");
					ReentrantLockDemo.this.lock.unlock();
				}
			}
		});
		executor.execute(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("task2"+this);
				ReentrantLockDemo.this.lock.lock();
				System.out.println("task2 get lock");
				try
				{
					TimeUnit.MILLISECONDS.sleep(800);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}finally {
					System.out.println("task2 completed");
					ReentrantLockDemo.this.lock.unlock();
				}
			}
		});
	}
}
