package com.lzh.random;

import java.util.Random;

public class AboutRandom
{
	public static void main(String[] args)
	{
		Random random=new Random(System.currentTimeMillis());
		int oneTen=random.nextInt(10);
		System.out.println(oneTen);
		
		/*
		int one = 0, two=0, three=0, fore=0, five=0;
		for (int i = 0; i < 10000; i++)
		{
			int one2ten=(int) (Math.random()*5+1);
			switch (one2ten)
			{
			case 1:
				one++;
				break;
			case 2:
				two++;
				break;
			case 3:
				three++;
				break;
			case 4:
				fore++;
				break;
			case 5:
				five++;
				break;
			}
		}
		System.out.println(one+" "+two+" "+three+" "+fore+" "+five);
		*/
	}
}
