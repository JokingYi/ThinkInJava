package com.lzh.flyWeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteFont implements Font
{
	private String color;
	private int size;
	private InnerFont innerFont;
	
	public ConcreteFont(InnerFont innerFont)
	{
		this.innerFont=innerFont;
	}
	
	@Override
	public void setFont(String color, int size)
	{
		this.color=color;
		this.size=size;
	}

	@Override
	public void getFont()
	{
		System.out.println("the string is "+innerFont+"; size: "+size+"color£º "+color);
	}
	
	public static void main(String[] args)
	{
		int size[]={2, 5, 1, 7, 4};
		String color[]={"red", "white", "gold", "yellow", "green"};
		String test="a test string";
		
		List<Font> fonts=new ArrayList<>();
		
		for(int i=0; i<test.length(); i++)
		{
			int j=(int) Math.floor(Math.random()*5);
			ConcreteFont concreteFont=new ConcreteFont(
					InnerFontFactory.getInnerFont(test.substring(i, i+1), "good"));
			concreteFont.setFont(color[j], size[j]);
			fonts.add(concreteFont);
		}
		System.out.println(fonts.size());
		System.out.println(InnerFontFactory.getTable().size());
	}
	
}
