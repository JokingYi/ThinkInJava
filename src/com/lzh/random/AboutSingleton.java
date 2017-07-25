package com.lzh.random;

import java.util.concurrent.TimeUnit;

public class AboutSingleton
{
	private static AboutSingleton aboutSingleton;
	private AboutSingleton()
	{
	}
	public static AboutSingleton getInstance()
	{
		if (aboutSingleton==null)
		{
			aboutSingleton=new AboutSingleton();
			return aboutSingleton;
		}
		return aboutSingleton;
	}
	public void testConcurrent(String string)
	{
		int sharedNum=1;
		if (string.equals("a"))
		{
			try
			{
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			sharedNum=5;
//			System.out.println("a:¡¡"+sharedNum);
		}
		if (string.equals("b"))
		{
			try
			{
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
//			System.out.println("b: "+sharedNum);
		}
		System.out.println(string+": "+sharedNum);
	}
	public static void main(String[] args)
	{
		AboutSingleton.getInstance().testConcurrent("a");
		AboutSingleton.getInstance().testConcurrent("b");
	}
}
