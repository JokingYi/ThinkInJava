package com.lzh.modifier;

import com.lzh.model.Book;
import com.lzh.utils.GeneralUtils;

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
	//要么在声明时初始化，要么在static块中初始化
	private static final String TE_STRING="";
	
	public AboutFinal(String string)
	{
		test=string;
	}
	
	public String getTest()
	{
		return test;
	}
	
	public static void main(String[] args)
	{
		//蓝而，并不是final，只是有那个作用？
//		GeneralUtils.getClassInfo(MethodInFinal.class);
	}
}
