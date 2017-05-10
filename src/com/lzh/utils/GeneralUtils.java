package com.lzh.utils;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

import com.lzh.enums.RainClass;

interface A{}
interface B{}
class AB implements A, B
{
	public void publicMethod()
	{
		
	}
	private void privateMehtod()
	{
		
	}
}

public class GeneralUtils
{
	private GeneralUtils() throws Exception
	{
		throw new Exception("this a utilClass which is not supposed to be instantialized!");
	}
	public static Set<String> getClassInfo(Class<?> target)
	{
		Set<String> methods=new TreeSet<>();
		System.out.println("analyzing class: "+target);
		System.out.println("interfaces");
		for (Class<?> inter: target.getInterfaces())
		{
//			System.out.println(inter.getName());
//			System.out.println(inter.getCanonicalName());
			System.out.println(inter.getSimpleName());
//			System.out.println(inter.getTypeName());
		}
		System.out.println("methods");
		for (Method method : target.getMethods())
		{
//			System.out.println(method.getName());
			methods.add(method.getName());
		}
//		for (Type type : target.getGenericInterfaces())
//		{
//			System.out.println(type);
//		}
		return methods;
	}
	
	public static void main(String[] args)
	{
		Set<String> rainMethods=getClassInfo(RainClass.class);
		Set<String> enumMethods=getClassInfo(Enum.class);
		//注意这种方法的使用
		rainMethods.removeAll(enumMethods);
		System.out.println("-------------");//getDes, main, values——这证明values是由编译器添加进去的， 并且是一个static
		System.out.println(rainMethods);
		
	}
}
