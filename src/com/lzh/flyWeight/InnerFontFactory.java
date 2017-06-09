package com.lzh.flyWeight;

import java.util.Hashtable;
import java.util.Map;

public class InnerFontFactory
{
	private static Map<String, InnerFont> table=new Hashtable<>();
	
	public static InnerFont getInnerFont(String content, String status)
	{
		if (table.get(content)!=null)
		{
			return table.get(content);
		}else
		{
			InnerFont innerFont=new InnerFont(content, status);
			table.put(content, innerFont);
			return innerFont;
		}
	}
	public static Map<String, InnerFont> getTable()
	{
		return table;
	}
}
