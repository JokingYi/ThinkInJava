package com.lzh.random;

import java.util.regex.Pattern;

public class ThePattern
{
	public static void main(String[] args)
	{
		String test="jpg";
		String regex="jpg|png|gif";
		Pattern pattern=Pattern.compile(regex);
		System.out.println(pattern.matcher(test).matches());
	}
}
