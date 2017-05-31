package com.lzh.random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeFormat
{
	private static int watchPoint=0;
	public static void main(String[] args)
	{
		Date date=new Date();
		int breakPoint=3;
		DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(format.format(date));
		System.out.println(breakPoint);
		TestTimeFormat.watchPoint=4;
		print();
		System.out.println(4);
	}
	public static void print()
	{
		System.out.println("test drop to frame");
		System.out.println("test drop to frame");
		System.out.println("test drop to frame");
	}
}
