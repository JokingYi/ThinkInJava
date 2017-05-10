package com.lzh.random;

enum Light{RED, GREEN, YELLOW}

public class AboutSwitch
{
	public static void main(String[] args)
	{
//		int i=(int) ((Math.random())*10);
		Light light=Light.GREEN;
		switch (light)
		{
		case RED:
			System.out.println(0);
			break;
		case GREEN:
			System.out.println(1);
			return;
		case YELLOW:
			System.out.println(2);
			break;
		}
	}
}
