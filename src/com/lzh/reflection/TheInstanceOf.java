package com.lzh.reflection;

interface A{}
class B implements A{}
class C extends B{}
public class TheInstanceOf
{
	public static void main(String[] args)
	{
		A a=null;
		B b=null;
		C c=null;
		System.out.println("a -- A "+(a instanceof A));
		System.out.println("b -- A "+(b instanceof A));
		System.out.println("c -- B "+(c instanceof B));
		a = new B();
		b=new B();
		c=new C();
		System.out.println("a -- A "+(a instanceof A));
		System.out.println("b -- A "+(b instanceof A));
		System.out.println("c -- B "+(c instanceof B));
		
	}
}
