package com.lzh.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel
{
	private static final int SIZE=1000;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		/*
		//测试由fileoutputstream返回的filechannel能不能读取它
		//抛出异常...
		FileChannel fileChannel=new FileOutputStream("d:/newIo.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		fileChannel.read(buffer);
		while(buffer.hasRemaining())
			System.out.println((char) buffer.get());
		*/
		/*
		FileChannel channel;//=new FileOutputStream("d:/newIo.txt").getChannel();
//		channel.write(ByteBuffer.wrap("write by channel".getBytes()));
//		channel.close();
//		channel=new RandomAccessFile("d:/newIo.txt", "rw").getChannel();
//		channel.position(channel.size());
//		channel.write(ByteBuffer.wrap(" some more writed".getBytes()));
//		channel.close();
		channel=new FileInputStream("d:/newIo.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		System.out.println(channel.read(buffer));
		buffer.flip();
		while(buffer.hasRemaining())
			System.out.print( (char) buffer.get());
		*/
	}
}
