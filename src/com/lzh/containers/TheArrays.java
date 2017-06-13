package com.lzh.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheArrays
{
	public static void main(String[] args)
	{
		List<String> test=Arrays.asList("1");
//		test.add("2");抛出异常
		
		/*
		//如果直接使用arrays.aslist 返回的列表，那么该list长度固定
		List<String> strings=new ArrayList<>(
				Arrays.asList("string", "test"));
		System.out.println(strings.size());
		strings.add("new");
		System.out.println(strings.size());
		*/
	}
}
