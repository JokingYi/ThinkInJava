package com.lzh.random;

public class TwoDimention
{
	public static void main(String[] args)
	{
		int[][] twoD=new int[3][2];
		for(int i=0;i<3; i++)
		{
			for(int j=0;j<2;j++)
			{
				twoD[i][j]=i+j;
			}
		}
//		System.out.println(twoD);
		for (int[] is : twoD)
		{
			for (int i : is)
			{
				System.out.println(i);
			}
		}
	}

}
