package com.lzh.random;

public class AboutException
{
	public static void main(String[] args)
	{
		String test=null;
		
		//which means ֻ��catchһ��
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
