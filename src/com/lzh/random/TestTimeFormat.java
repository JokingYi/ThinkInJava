package com.lzh.random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeFormat
{
	public static void main(String[] args)
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(format.format(date));
	}
}
