package com.lzh.innerClass;

interface Incrementable
{
	void increase();
}

class MyIncrement
{
	public void increase()
	{
		System.out.println("do other process except increasing");
	}
}

public class Closure extends MyIncrement
{	
	@Override
	public void increase()
	{
		System.out.println("myincrement subclass");
	}
	
	private class MinPointer implements Incrementable
	{
		@Override
		public void increase()
		{
			Closure.this.increase();
		}
		
	}
	
	public Incrementable getPointer()
	{
		return new MinPointer();
	}
	
	public static void main(String[] args)
	{
		Incrementable incrementable=new Closure().getPointer();
		incrementable.increase();
	}
}
