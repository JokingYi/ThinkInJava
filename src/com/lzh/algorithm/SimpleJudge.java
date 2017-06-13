package com.lzh.algorithm;

public class SimpleJudge
{
	public static void main(String[] args)
	{
		int i=4;
		for(boolean b=false; b= !b; i--)
		{
			if (i==3)
			{
				b=false;
				System.out.println("the false");
			}
			System.out.println("not change");//只输出这个
		}
	}
}
