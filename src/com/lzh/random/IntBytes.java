package com.lzh.random;

public class IntBytes
{
	public static void main(String[] args)
	{
		
//		System.out.println(Integer.toBinaryString(-12).substring(24));
//		System.out.println(23 & 0xff);
		byte b=-12;
		int int_b2=b;
		System.out.println((byte)int_b2);
		//保持了二进制补码的一致性
		int int_b=b & 0xff;
		System.out.println(int_b);
		System.out.println((byte)int_b);
//		System.out.println(b & 0xff);
	}
}
