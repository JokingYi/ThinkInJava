package com.lzh.random;

/**
 * @author ASUS
 *
 * @param <T> : call me "Type Parameter"
 */
public class GenericContainerDemo<T>
{
	private T item;
	
	public static void main(String[] args)
	{
		/*
		 // simple test
		GenericContainerDemo<String> containerDemo=
				new GenericContainerDemo<String>("test");
		System.out.println(containerDemo.getItem());
		*/
		// type parameter are specified to Object, and it's okay with String
		GenericContainerDemo<Object> objects=new GenericContainerDemo<Object>("string");
		System.out.println(objects.getItem());
	}
	public GenericContainerDemo(T item)
	{
		super();
		this.item = item;
	}
	public void setItem(T item)
	{
		this.item = item;
	}
	public T getItem()
	{
		return item;
	}
}
class TwoGenericContainer<A,B,C>
{
	private A a;
	private B b;
	private C c;
	
	public A getA()
	{
		return a;
	}
	public void setA(A a)
	{
		this.a = a;
	}
	public B getB()
	{
		return b;
	}
	public void setB(B b)
	{
		this.b = b;
	}
	public C getC()
	{
		return c;
	}
	public void setC(C c)
	{
		this.c = c;
	}
}