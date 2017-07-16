package com.lzh.concurrency.documention;

public class DeadLock
{
	private static class Friend
	{
		private String name;
		
		public Friend(String name)
		{
			super();
			this.name = name;
		}
		public String getName()
		{
			return name;
		}
		synchronized public void bow(Friend friend)
		{
			System.out.format("%s has bow to me!%n", this.getName());
			friend.bowBack(this);
		}
		synchronized public void bowBack(Friend friend)
		{
			System.out.println("back");
			System.out.format("%s has bow to me!%n", this.getName());
		}
	}
	public static void main(String[] args)
	{
		Friend friend=new Friend("a");
		Friend friend1=new Friend("b");
		//都先抢好一个锁，然后调用另一个需要该锁的方法
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				friend.bow(friend1);
			}
		}).start();;
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				/*try
				{
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}*/
				friend1.bow(friend);
			}
		}).start();
	}
}
