package com.lzh.containers;

interface Movable
{
	void move();
	void basicMethod();
}

abstract class WithLeg implements Movable
{
	@Override
	public void basicMethod()
	{
		System.out.println("basic method implemented by the WithLeg");
	}
}

class Ant extends WithLeg
{

	@Override
	public void move()
	{
		System.out.println("i have 6 legs, but i'm slow");
	}
	
}

public class SkeletalImpl
{
	public static void main(String[] args)
	{
		Movable ant =new Ant();
		ant.move();
		ant.basicMethod();
	}
}
