package com.lzh.random;

import java.util.regex.Pattern;

public class ThePattern
{
	public static void main(String[] args)
	{
		Pattern pattern=Pattern.compile("s\\w+");
		System.out.println(pattern.matcher("spring").matches());
		/*
		//about the charachter |
		String test="jpg";
		String regex="jpg|png|gif";
		Pattern pattern=Pattern.compile(regex);
		System.out.println(pattern.matcher(test).matches());
		*/
	}
	private static void testRegexApi()
	{
		
	}
	
}
