package com.lzh.factoryDesignPattern;

public class Bwm320Factory implements FactoryBwmMethod
{

	@Override
	public Bwm createBwmMethod()
	{
		return new Bwm320();
	}
	
}
