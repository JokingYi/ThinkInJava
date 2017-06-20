package com.lzh.test;

import java.text.DecimalFormat;

public class TheDecimalFormat
{
	public static void main(String[] args)
	{
		double pi=3.141592;
		DecimalFormat format=new DecimalFormat();
		format.setMaximumFractionDigits(3);
		System.out.println(format.format(pi));
		
		long num=201307500115l;
		System.out.println(new DecimalFormat("#.##E0").format(num));
		System.out.println(new DecimalFormat(",###").format(num));
		
	}
}
