package com.lzh.random;

class Sup1
{
	public int print()
	{
		return 1;
	}
}

class Base1 extends Sup1
{
	//编译不通过。可以从极端情况考虑，因为jvm不知道选择哪种情况
//	public long print()
//	{
//		return 2;
//	}
}

public class OverrideReturnType
{

}
