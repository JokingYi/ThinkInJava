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
			System.out.format("%s has bow to me!", this.getName());
		}
	}
	public static void main(String[] args)
	{
		Friend friend=new Friend("a");
		Friend friend1=new Friend("b");
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
				friend1.bow(friend);
			}
		}).start();
	}
}
