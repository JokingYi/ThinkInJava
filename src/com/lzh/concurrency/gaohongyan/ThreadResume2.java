package com.lzh.concurrency.gaohongyan;

public class ThreadResume2
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread=new Thread(new Runnable()
		{
			private int i=0;
			@Override
			public void run()
			{
				while(true)
				{
					i++;
					System.out.println(i);
				}
			}
		});
		thread.start();
		Thread.sleep(10);
		thread.suspend();
		System.out.println("main end!");//并不会输出，因为println（）方法是并发的
	}
}
