package com.lzh.concurrency.guardlock;

public class Drop
{
	private String message;
	private boolean empty=true;
	
	synchronized public String take()
	{
		while(empty)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		empty=true;
		notifyAll();
		return message;
	}
	synchronized public void put(String message)
	{
		while(!empty)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		empty=false;
		this.message=message;
		notifyAll();
	}
}
