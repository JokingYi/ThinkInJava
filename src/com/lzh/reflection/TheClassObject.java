package com.lzh.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Container
{
	static 
	{
		System.out.println("in static block Container ");
	}
}
class Bottle extends Container
{
	public String tag;
	public int size;
	static 
	{
		System.out.println("in static block Bottle ");
	}
	public void testMethod()
	{
		System.out.println("inside one method");
	}
}
public class TheClassObject
{
	public static void printClassInfo(Class<?> c)
	{
		System.out.println("the class full name is"+c.getName());
		System.out.println("is interface?"+c.isInterface());
		//with diff implemention
		Field[] fields=c.getDeclaredFields();
		
		System.out.println("-------------the fields in class");
		Object object=null;
		try
		{
			object=c.newInstance();
		} catch (InstantiationException | IllegalAccessException e1)
		{
			e1.printStackTrace();
		}
		for (Field field : fields)
		{
			System.out.println(field.getName());
			field.setAccessible(true);
			if (field.getName().equals("size"))
			{
				try
				{
					System.out.println(field.get(object));
				} catch (IllegalArgumentException | IllegalAccessException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("-------------the fields in class");
		System.out.println("-------------the methods in class");
		Method[] methods=c.getDeclaredMethods();
		for (Method method : methods)
		{
			System.out.println(method.toString());
		}
		System.out.println("-------------the methods in class");
		
	}
	public static void main(String[] args)
	{
		/*
		//class object with generic
		Class<Bottle> c=Bottle.class;
		Class<? super Bottle> up=c.getSuperclass();
		try
		{
			//compare the diff between them;
			Bottle bottle= c.newInstance();
			Container container=(Container) up.newInstance();
		} catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		*/
		//something about field's value and class info
		try
		{
			Class<?> c=Class.forName("com.lzh.reflection.Bottle");
			printClassInfo(c);
			Class<?> up=c.getSuperclass();
			printClassInfo(up);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
