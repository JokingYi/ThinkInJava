package com.lzh.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

import javax.sound.midi.Soundbank;

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

class PrivateFinalField
{
	private  String testFinal="";
	private void testFinalMethod()
	{}
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
		System.out.println("all the interfaces >>>>");
		for (Class<?> inter: target.getInterfaces())
		{
//			System.out.println(inter.getName());
//			System.out.println(inter.getCanonicalName());
			System.out.println(inter.getSimpleName());
//			System.out.println(inter.getTypeName());
		}
		System.out.println("all the methods >>>>>"); 
		for (Method method : target.getDeclaredMethods())
		{
//			System.out.println(method.getName());
			methods.add(method.getName());
			System.out.print(method.getName()+"  ");
			System.out.println(Modifier.isFinal(method.getModifiers()));
		}
//		for (Type type : target.getGenericInterfaces())
//		{
//			System.out.println(type);
//		}
		System.out.println("all the fields >>>");
		
		for (Field field : target.getDeclaredFields())
		{
			System.out.println("the private is final? "+Modifier.isFinal(field.getModifiers()));
			System.out.println(field.getName());
		}
		return methods;
	}
	
	public static void main(String[] args)
	{
		//private ���ε�method�� ��Ȼ��ʽΪfinal����ʵ���ϲ���final���ε�
		GeneralUtils.getClassInfo(PrivateFinalField.class);
/*		
		Set<String> rainMethods=getClassInfo(RainClass.class);
		Set<String> enumMethods=getClassInfo(Enum.class);
		//ע�����ַ�����ʹ��
		rainMethods.removeAll(enumMethods);
		System.out.println("-------------");//getDes, main, values������֤��values���ɱ�������ӽ�ȥ�ģ� ������һ��static
		System.out.println(rainMethods);
*/		
	}
}
