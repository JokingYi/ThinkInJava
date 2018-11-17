package com.lzh.concurrency;

import java.util.concurrent.TimeUnit;

class Sleeper extends Thread
{
	private long sleepTime;
	public Sleeper(String name, long sleepTime)
	{
		super(name);
		this.sleepTime=sleepTime;
		start();
	}
	@Override
	public void run()
	{
		try
		{
			sleep(sleepTime);
		} catch (InterruptedException e)
		{
			System.out.println("interupted");
			e.printStackTrace();
		}
		System.out.println(getName()+" has awakend");
	}
}

class Joinner extends Thread
{
	private Sleeper sleeper;
	public Joinner(String name, Sleeper sleeper)
	{
		super(name);
		this.sleeper = sleeper;
		start();
	}
	@Override
	public void run()
	{
		try
		{
			sleeper.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(getName()+" join completed");
	}
}

public class Joining
{
	public static void main(String[] args) throws InterruptedException
	{
		Joining demo=new Joining();
		demo.longer();
	}
	public void longer() throws InterruptedException {
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("sleep end");
				}
			}
		});
		thread.start();
		thread.join(1000);
		System.out.println("join ended");
	}
	public void basic() {
		Sleeper sleeper1=new Sleeper("long", 1500);
		Sleeper sleeper2=new Sleeper("zhi", 1500);
		Joinner joinner1=new Joinner("1", sleeper1);
		Joinner joinner2=new Joinner("2", sleeper2);
		sleeper1.interrupt();
	}
}
