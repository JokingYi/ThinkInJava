package com.lzh.random;

public class AboutException
{
	public static void main(String[] args)
	{
		String test=null;
		
		//which means 只会catch一个
		try
		{
			System.out.println(test.length());
		}catch (NullPointerException e) 
		{
			System.out.println("npe");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
