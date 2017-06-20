package com.lzh.encode;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class TheCharSet
{
	public static void main(String[] args)
	{
		Charset charset=Charset.forName("utf-8");
		ByteBuffer buffer=charset.encode("abc");
//		System.out.println(buffer.getChar());
//		System.out.println(buffer.getInt());
		for (byte b : buffer.array())
		{
			System.out.println(b);
		}
	}
}
