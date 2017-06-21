package com.lzh.containers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class LinkedListDemo
{
	public static void main(String[] args)
	{
		List<String> strings=new LinkedList<>();
		strings.add("hello world");
		strings.add("steins gate");
		strings.add("one piece");
		strings.add("walle");
		Collections.reverse(strings);
		Pattern pattern=Pattern.compile("steins \\w+");
		for (String string : strings)
		{
			System.out.println(string);
			if (pattern.matcher(string).matches())
			{
				System.out.println(string);
			} 
		}
	}
}
