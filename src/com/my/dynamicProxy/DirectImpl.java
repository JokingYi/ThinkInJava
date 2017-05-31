package com.my.dynamicProxy;

public class DirectImpl implements BaseInter
{

	@Override
	public void asSuper()
	{
		System.out.println("in super");
	}

	@Override
	public void asBase()
	{
		System.out.println("in base");
	}

}
