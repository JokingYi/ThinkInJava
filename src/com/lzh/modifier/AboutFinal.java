package com.lzh.modifier;

final class MethodInFinal
{
	public void foo(){}
}

public class AboutFinal
{
	//its supposed to be initialized in the constructor
	private final String test;
	//static final ---only one 
	//final ---one for each instance
	private static final String TE_STRING="";
	public AboutFinal(String string)
	{
		test=string;
	}
	public static void main(String[] args)
	{
		//蓝而，并不是final，只是有那个作用？
//		GeneralUtils.getClassInfo(MethodInFinal.class);
	}
}
