package com.lzh.factoryDesignPattern;

public class Bwm523Factory implements FactoryBwmMethod
{

	@Override
	public Bwm createBwmMethod()
	{
		return new Bwm523();
	}

}
