package com.lzh.random;

public class Finalization
{
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("test");
	}
	public void test()
	{
		System.out.println("print");
	}
	public static void main(String[] args)
	{
		new Finalization().test();
		System.gc();
	}
}
