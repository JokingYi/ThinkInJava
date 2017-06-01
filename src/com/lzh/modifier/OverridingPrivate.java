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
	//重载不能改变修饰符，添加一个@override可以更容易看出
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
