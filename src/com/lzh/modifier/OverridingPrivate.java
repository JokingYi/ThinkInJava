package com.lzh.modifier;

class BasePrivate
{
	private void g(){System.out.println("base g");}
	private final void f(){System.out.println("base f");}
}

public class OverridingPrivate extends BasePrivate
{
	public void g()
	{
		System.out.println("override g ");
	}
	//���ز��ܸı����η������һ��@override���Ը����׿���
	public void f()
	{
		System.out.println("override f ");
	}
	public static void main(String[] args)
	{
		OverridingPrivate test=new OverridingPrivate();
		test.f();
		test.g();
		BasePrivate baseTest=test;
//		cann't get access to the f and g methods
	}
}
