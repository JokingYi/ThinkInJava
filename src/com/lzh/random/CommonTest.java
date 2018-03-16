package com.lzh.random;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class CommonTest
{
	@Ignore
	@Test
	public void testSystemSetProperties()
	{
		System.setProperty("key", "value");
		assertEquals("value", System.getProperty("key"));
	}
	
	@Test
	public void testArrayListSize()
	{
		ArrayList<String> strings=new ArrayList<>();
		strings.size();
	}
}
