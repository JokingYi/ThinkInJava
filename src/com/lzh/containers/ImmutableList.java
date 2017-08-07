package com.lzh.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableList
{
	private final List<String> strings;
	public ImmutableList(List<String> strings)
	{
		this.strings = Collections.unmodifiableList(strings);
		//shift to the next one will be complete immutable
		//but be attention, if the you replace the string(which itself is immutabel) with 
		//another object which is immutable, then this object is still modifierable
//		this.strings=Collections.unmodifiableList(new ArrayList<>(strings));
	}
	public void testMutate()
	{
		strings.add("test");
	}
	public void verify()
	{
		for (String string : strings)
		{
			System.out.println(string);
		}
	}
	public static void main(String[] args)
	{
		//throw an exception, but no compile error
		//new ImmutableList(new ArrayList<>()).testMutate();
		//but it's still possible to mutate the inner list
		List<String> strings=new ArrayList<>();
		strings.addAll(Arrays.asList("1", "2", "3"));
		ImmutableList immutableList=new ImmutableList(strings);
		strings.add("4");
		immutableList.verify();
	}
}
