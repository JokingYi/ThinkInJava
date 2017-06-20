package com.lzh.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.security.Timestamp;

public class GetData
{
	private static final int SIZE=1024;
	public static void main(String[] args)
	{
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		int i=0;
		while(i++<buffer.limit())
		{
			if (buffer.get()!=0)
			{
				System.out.println("nonzero");
			}
		}
		System.out.println(i);
		buffer.rewind();
		
		IntBuffer intBuffer=buffer.asIntBuffer();
		System.out.println(intBuffer.capacity());
		System.out.println(intBuffer.limit());
		
		/*
		CharBuffer temp;
		temp=buffer.asCharBuffer();
		temp.put("howdy");
		
		System.out.println(temp.limit());
		System.out.println(temp.capacity());
//		temp.clear();
//		temp.put("overwirte");
		char c;
		while((c=buffer.getChar())!=0)
		{
			System.out.println(c+" ");
		}
		*/
	}
}
