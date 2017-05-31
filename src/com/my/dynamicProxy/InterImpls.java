package com.my.dynamicProxy;

public class InterImpls implements Inter1, Inter2
{

	@Override
	public void method2()
	{
		System.out.println("method 2 do something");
	}

	@Override
	public void method1(String string)
	{
		System.out.println("method1 do something");
	}

}
