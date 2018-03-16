package com.lzh.concurrency;

import java.util.Vector;

public class ActorPattern
{
	protected static class Account
	{
		private Integer balance;
		private Vector<Message> messages;
		public void deposit(int num)
		{
			balance+=num;
		}
		public void withdraw(int num)
		{
			if(balance>num)
			{
				balance-=num;
				return ;
			}
			throw new RuntimeException("not enough money!");
		}
		
		public synchronized void putMessage(Message message)
		{
			messages.addElement(message);
			
		}
	}
	protected static class Message
	{
		public Boolean type;
		public Integer num;
	}
}
