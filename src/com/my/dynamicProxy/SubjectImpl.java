package com.my.dynamicProxy;

public class SubjectImpl implements ISubject
{

	@Override
	public void request()
	{
		System.out.println("in original!");
	}

}
