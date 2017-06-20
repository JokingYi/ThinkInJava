package com.lzh.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText
{
	private static final int SIZE=100;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		
		/*
		FileChannel channel=new FileInputStream("d:/copy.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		channel.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer().toString());
//		buffer.rewind();
		System.out.println(Charset.forName("utf-8").decode(buffer));
		*/
		
	}
}
