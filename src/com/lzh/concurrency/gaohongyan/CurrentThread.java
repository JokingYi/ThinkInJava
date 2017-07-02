package com.lzh.concurrency.gaohongyan;

import java.util.concurrent.TimeUnit;

class MyThread implements Runnable
{
	public MyThread()
	{
		System.out.println("the constructors: "+Thread.currentThread().getName());
	}
	@Override
	public void run()
	{
		System.out.println("the run method: "+Thread.currentThread().getName());
	}
	
}

public class CurrentThread
{
	public static void main(String[] args) throws InterruptedException
	{
		MyThread myThread=new MyThread();
		Thread thread=new Thread(myThread);
		System.out.println("start:¡¡"+thread.isAlive());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("end: "+thread.isAlive());//for the thread finished, so output is false;
	}
}
