package com.lzh.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class GetChannel
{
	private static final int SIZE=20480;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		FileChannel channel=null;
		/*
		//more about order(), please refer to ByteBufferDemo
		byte[] bs="test".getBytes();
		for (byte b : bs)
		{
			System.out.println(b);
		}
		ByteBuffer byteBuffer=ByteBuffer.wrap(bs);
		ByteBuffer newByteBuffer= byteBuffer.order(ByteOrder.BIG_ENDIAN);
		System.out.println("----------");
		System.out.println(newByteBuffer.get());
		System.out.println(newByteBuffer.get());
		System.out.println("----------");
		for (byte b : newByteBuffer.array())
		{
			System.out.println(b);
		}
		*/
		
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
		//write data to certain file by channel
		long start=System.currentTimeMillis();
		FileChannel channel=new FileOutputStream("d:/newIo.txt").getChannel();
//		System.out.println(channel.position());
		byte[] bigData=new byte[100000];
		for (int i = 0; i < bigData.length; i++)
		{
			bigData[i]=(byte) i;
		}
//		channel.write(ByteBuffer.wrap("write by channel".getBytes()));
		channel.write(ByteBuffer.wrap(bigData));
		System.out.println("time consumed: "+(System.currentTimeMillis()-start));
//		System.out.println(channel.position());
		channel.close();
		*/
		
		/*
		//compare nio output to normal buffered outputstream
		//but the latter win!!
		long start2=System.currentTimeMillis();
		OutputStream outputStream=new BufferedOutputStream(
				new FileOutputStream("d:/compareToNIO.txt"));
		byte[] bigData2=new byte[100000];
		for (int i = 0; i < bigData2.length; i++)
		{
			bigData2[i]=(byte) i;
		}
		
		outputStream.write(bigData2);
		System.out.println("normal consumed: "+(System.currentTimeMillis()-start2));
		outputStream.close();
		*/
		
		//the follow block show how channel get by another stream
		/*channel=new RandomAccessFile("d:/newIo.txt", "rw").getChannel();
		channel.position(channel.size());
		channel.write(ByteBuffer.wrap(" some more writed".getBytes()));
		channel.close();*/
		
		//the next two blocks compared the performance between normal buffered 
		//inputstream and file channel
		//which turns out that the bufferd inputstream precede the file channel
		/*
		System.out.println("method1");
		long start3=System.currentTimeMillis();
		channel=new FileInputStream("d:/newIo.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		int num;
		while((num=channel.read(buffer))!=-1)
		{
//			System.out.println(channel.read(buffer));
			buffer.position(0);
			while(buffer.hasRemaining())
			{
				System.out.print(buffer.get());
			}
			System.out.println();
			buffer.position(0);
		}
		System.out.println();
		System.out.println("time consumed when read file by channel: "+
				(System.currentTimeMillis()-start3));
		channel.close();
		*/
/*		
		System.out.println("method2");
		long start4=System.currentTimeMillis();
		InputStream inputStream=new BufferedInputStream(
				new FileInputStream("d:/newIo.txt"));
		byte[] buffer2=new byte[20480];
		int numRead=inputStream.read(buffer2);
		while(numRead!=-1)
		{
			System.out.println("circle");
			for (int j = 0; j < buffer2.length; j++)
			{
				System.out.print(buffer2[j]);
			}
			numRead=inputStream.read(buffer2);
		}
		System.out.println();
		System.out.println("time consumed when read file by buffered inpustream: "+
				(System.currentTimeMillis()-start4));
		inputStream.close();
		*/
	}
}
