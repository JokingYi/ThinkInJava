package com.lzh.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtil
{
	public static void main(String[] args)
	{
//		System.out.println(Integer.toHexString(-1));
//		System.out.println(Integer.toBinaryString(-1));
//		System.out.println(0xff & -1);
//		System.out.println(-1);
		
//		System.out.println((int)Byte.MIN_VALUE);
//		System.out.println(Integer.toBinaryString(-1));
		
		String username="Бъ";
		try
		{
			System.out.println("before encode...");
			for (byte b : username.getBytes())
			{
				System.out.print(b+" ");
			}
			System.out.println();
			
			MessageDigest messageDigest=MessageDigest.getInstance("SHA");
			messageDigest.update(username.getBytes());
			byte data[] =messageDigest.digest();
			
			System.out.println("after encode...");
			for (byte d : data)
			{
				System.out.print(d+" ");
			}
			System.out.println();
			
			System.out.println(data.length);
			System.out.println(byteToHexString(data));
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String byteToHexString(byte data[])
	{
		StringBuffer stringBuffer=new StringBuffer();
		for (int i = 0; i < data.length; i++)
		{
			System.out.println(Integer.toHexString(data[i] & 0xff));
			stringBuffer.append(Integer.toHexString(data[i] & 0xff));
		}
		return stringBuffer.toString();
	}
}
