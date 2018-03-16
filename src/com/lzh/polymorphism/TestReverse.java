package com.lzh.polymorphism;

public class TestReverse
{
	public static void main(String[] args)
	{
		Shape shape=new Triangular();
		Triangular triangular=(Triangular) shape;
		triangular.draw();
	}
}
