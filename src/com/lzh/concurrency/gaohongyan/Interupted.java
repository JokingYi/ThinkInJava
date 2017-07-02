package com.lzh.concurrency.gaohongyan;

class AboutInterupt implements Runnable
{

	@Override
	public void run()
	{
		for(int i=0;i<2000;i++)
		{
			System.out.println(i);
		}
	}
	
}

public class Interupted
{
	public static void main(String[] args)
	{
		Thread thread=new Thread(new AboutInterupt());
		thread.start();
		System.out.println("thread started");
		try
		{
			Thread.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		thread.interrupt();
//		Thread.currentThread().interrupt();
		System.out.println("interupted");
		//interupted()方法测试当前线程是否中断，而且有将状态标识清除的效果
//		System.out.println("if the thread is interupted："+Thread.interrupted());
//		System.out.println("if the thread is interupted："+Thread.interrupted());
		System.out.println("if the thread is interupted: "+thread.isInterrupted());
	}
}
