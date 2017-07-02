package com.lzh.concurrency.guardlock;

public class Consumer implements Runnable
{
	private Drop drop;
	
	public Consumer(Drop drop)
	{
		super();
		this.drop = drop;
	}

	@Override
	public void run()
	{
		for (String message=drop.take(); !message.equals("done"); message=drop.take())
		{
			System.out.format("MESSAGE RECEIVED: %s%n", message);
		}
	}
	public static void main(String[] args)
	{
		Drop drop=new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
	}
}
