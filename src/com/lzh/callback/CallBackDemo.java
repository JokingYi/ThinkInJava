package com.lzh.callback;

import java.util.Observable;
import java.util.Observer;

/**
 * simple call back demo
 * @author joking
 *
 */
public class CallBackDemo
{
	private Observer observer=null;
	
	public static void main(String[] args)
	{
		CallBackDemo demo=new CallBackDemo();
		demo.observer=new Observer()
		{
			@Override
			public void update(Observable o, Object arg)
			{
				System.out.println("get data");
				System.out.println((String)arg);
			}
		};
		System.out.println("observer set...");
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("time consuming task...");
				try
				{
					Thread.sleep(2000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				demo.observer.update(null, "data");
			}
		}).start();
	}
}
