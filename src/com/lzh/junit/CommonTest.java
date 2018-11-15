package com.lzh.junit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CommonTest
{
	int num=10000;
	@Test
	public void testTemp() {
		BigInteger integer=BigInteger.ONE;
		System.out.println(integer.nextProbablePrime());
	}
//	@Test
	public void assignValue()
	{
		int i;
		System.out.println(i=1);
	}
//	@Test
	public void testArrayFill()
	{
		Arrays.fill(new char[2], '2');
	}
//	@Test
	public void testStringFunc()
	{
		String temp="a";
		System.out.println(temp.split("")[0]);
		for (byte b : temp.getBytes())
		{
			System.out.println(b);
		}
		for (char c : temp.toCharArray())
		{
			System.out.println(c);
		}
	}
//	@Test
	public void testCon()
	{
		Date start=new Date();
		System.out.println(start);
		while(num-->0){
		}
		System.out.println(new Date());
		System.out.println((new Date().getTime()-start.getTime())/1000d);
	}
//	@Test
	public void temp()
	{
		List<String> strings=new ArrayList<>();
		System.out.println(Arrays.toString(strings.getClass().getTypeParameters()));
	}
//	@Test
	public void testMockAny()
	{
		Temp temp=mock(Temp.class);
		doAnswer(new Answer<Void>()
		{
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable
			{
				String param=(String) invocation.getArguments()[0];
				System.out.println(param);//bingo!
				return null;
			}
		}).when(temp).setString(any());
		temp.setString("test pring");
	}
//	@Test
	public void testAny()
	{
		Temp temp=new Temp();
		temp.setString(returnAny());
		System.out.println(temp.getString());
	}
//	@Test
	public void testIterable()
	{
		IterableClass iterableClass=new IterableClass("a b c d");
		for (String iterable_element : iterableClass)
		{
			System.out.println(iterable_element);
		}
	}
	public <T>T returnAny()
	{
		return null;
	}
}

class Temp
{
	private String string;
	public String getString()
	{
		return string;
	}
	public void setString(String string)
	{
		this.string = string;
	}
}
class IterableClass implements Iterable<String>
{
	String string;
	public IterableClass(String string)
	{
		this.string=string;
	}
	@Override
	public Iterator<String> iterator()
	{
		String[] strings=string.split(" ");
		
		return new Iterator<String>()
		{
			int index=0;
			@Override
			public boolean hasNext()
			{
				return index!=strings.length;
			}

			@Override
			public String next()
			{
				return strings[index++];
			}
		};
	}
	
}