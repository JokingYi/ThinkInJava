package com.lzh.test;

import java.util.regex.Pattern;

public class Scripts
{
	private Scripts()
	{
	}
	public static void main(String[] args)
	{
		Pattern pattern=Pattern.compile(".*m");
		System.out.println(pattern.matcher("room").matches());
	}
}
