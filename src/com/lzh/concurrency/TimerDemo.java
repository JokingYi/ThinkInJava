package com.lzh.concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo
{
	public static void main(String[] args)
	{
		TimerDemo timerDemo=new TimerDemo();
		timerDemo.timerConsException();
		
	}
	public void timerCons1()
	{
		Timer timer=new Timer();
		timer.schedule(new PrintTask("task4", 4000), 1000, 1000);
		timer.schedule(new PrintTask("task1", 1000), 1000, 1000);//print lost
	}
	/**
	 * once the scheduled task throw an exception,
	 * the thread which is responsible for running task will terminate 
	 */
	public void timerConsException()
	{
		Timer timer=new Timer();
		timer.schedule(new TimerTask()
		{
			
			@Override
			public void run()
			{
				throw new RuntimeException("test");
			}
		}, 1000);
		timer.schedule(new PrintTask("task", 10), 2000);//no output
	}
	class PrintTask extends TimerTask{
		private final String info;
		private int time;
		public PrintTask(String info, int time)
		{
			this.info=info;
			this.time=time;
		}
		@Override
		public void run()
		{
			System.out.println(info);
			try
			{
				Thread.sleep(time);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(info);
		}
	}
	public void basic()
	{
		Timer timer=new Timer();
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				System.out.println("output");
			}
		}, 1000);
	}
}
