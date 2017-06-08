package com.lzh.innerClass;

public class NestedClass
{
	private void print()
	{
		System.out.println("private method in class");
	}
		
	//可以从其他包获得，而不依赖于外部类
	public static class InClass
	{
		private String test;
		public InClass()
		{
			test="default";
		}
		public InClass(String test)
		{
			this.test = test;
		}
		@Override
		public String toString()
		{
			return test;
		}
	}
	//依赖于与外部类的链接
	public class InClass2
	{
		private String test2;
		public InClass2()
		{
			test2="";
		}
		@Override
		public String toString()
		{
			//因为依赖于外部链接，所以可以直接调用外部类的方法，甚至是private方法,其实就是类似于一个公共方法里面调用private方法；
			print();
			return test2;
		}
	}
}
