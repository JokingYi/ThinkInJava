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
//		thread.run();//˳��ִ��
		thread.start();//�����������ִ�У�����ִ��
		System.out.println("output in main");
	}
}
