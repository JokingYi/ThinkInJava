package com.lzh.concurrency.guardlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable
{
	private Drop drop;
	public Producer(Drop drop)
	{
		super();
		this.drop = drop;
	}

	@Override
	public void run()
	{
		String[] strings ={"message1", "message2", "message3", "message4"};
		for (int i = 0; i < strings.length; i++)
		{
			drop.put(strings[i]);
			try
			{
				TimeUnit.SECONDS.sleep(new Random().nextInt(3));
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		drop.put("done");
		
	}
	
}
