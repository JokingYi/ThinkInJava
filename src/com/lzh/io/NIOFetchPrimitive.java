package com.lzh.io;

import java.nio.ByteBuffer;

public class NIOFetchPrimitive
{
	private static final int SIZE=12;
	public static void main(String[] args)
	{
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		buffer.rewind();
		buffer.asCharBuffer().put("abcd");
		char c;
		while((c=buffer.getChar())!=0)
		{
			System.out.println(c);
		}
	}

}
