package com.lzh.factoryDesignPattern;

public class Client
{
	public static void main(String[] args)
	{
		Bwm bwm= BwmFactory.createBwm("320");
	}
}
