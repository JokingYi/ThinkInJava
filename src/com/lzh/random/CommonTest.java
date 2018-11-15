package com.lzh.random;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

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
	
//	@Test
	public void testArrayListSize()
	{
		ArrayList<String> strings=new ArrayList<>();
		strings.size();
	}
	@Test
	public void test1()
	{
		Random random;
		Arrays fdsd;
	}
}
