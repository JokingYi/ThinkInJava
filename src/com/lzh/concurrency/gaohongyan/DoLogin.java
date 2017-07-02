package com.lzh.concurrency.gaohongyan;

public class DoLogin
{
	private static class Alogin implements Runnable
	{
		@Override
		public void run()
		{
			LoginServlet.dopost("a", "aa");
		}
		
	}
	private static class Blogin implements Runnable
	{
		@Override
		public void run()
		{
			LoginServlet.dopost("b", "bb");
		}
	}
	public static void main(String[] args)
	{
		new Thread(new Alogin()).start();
		new Thread(new Blogin()).start();
		System.out.println();
	}
}
