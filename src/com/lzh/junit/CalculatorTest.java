package com.lzh.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest
{
	@Test
	public void testAdd()
	{
		Calculator calculator=new Calculator();
		double result= calculator.add(2, 3);
		assertEquals(3, result, 0);
	}
}
