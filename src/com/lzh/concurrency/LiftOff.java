package com.lzh.concurrency;

public class LiftOff implements Runnable
{
	public static int taskCount=0;
	private final int id=taskCount++;
	protected int countDown=10;
	
	public LiftOff()
	{
	}
	public LiftOff(int countDown)
	{
		this.countDown = countDown;
	}
	
	public String status()
	{
		return "#"+id+
				" "+(countDown>0?countDown:"liftoff");
	}
	
	@Override
	public void run()
	{
		while(countDown-->0)
		{
			System.out.println(status());
			Thread.yield();
		}
	}
	
	public static void main(String[] args)
	{
		new Thread(new LiftOff(3)).start();
	}
}
