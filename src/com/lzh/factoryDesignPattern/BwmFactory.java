package com.lzh.factoryDesignPattern;

public class BwmFactory
{
	public static Bwm createBwm(String type)
	{
		if (type.equals("320"))
		{
			return new Bwm320();
		}else
		{
			return new Bwm523();
		}
	}
}
