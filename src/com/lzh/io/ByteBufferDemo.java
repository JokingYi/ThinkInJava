package com.lzh.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * the method order() is not what i think like sort an array;
 * @author ASUS
 *
 */
public class ByteBufferDemo
{
	public static void main(String[] args)
	{
		/*ByteBuffer byteBuffer=ByteBuffer.allocate(4);
		ByteBuffer newByteBuffer=byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		byte[] byteSrc="test".getBytes();
		byteBuffer.put(byteSrc);
		byte[] bytes=byteBuffer.array();
		System.out.println(Arrays.toString(bytes));*/
		byte[] x=new byte[100];
		ByteBuffer buf=ByteBuffer.allocate(100);
		buf.putInt(0x01020304);
		buf.putChar((char)0x0506);
		buf.putLong(0x0102030405060708L);
		buf.putDouble(3.3e15);
		System.out.println("-------"+buf.position());
		buf.position(0);
		buf.get(x);
		/*System.out.println(">>>>>>>>>>");
		for (byte b : x)
		{
			System.out.println(b);
		}
		System.out.println(">>>>>>>>>>");*/
		System.out.println(x[0]+","+x[1]+","+x[2]+","+x[3]);
		buf.position(0);
		System.out.println(Integer.toHexString(buf.getInt()));
		System.out.println(Integer.toHexString(buf.getChar()));
		System.out.println(Long.toHexString(buf.getLong()));
		System.out.println(buf.getDouble());
		buf.order(ByteOrder.LITTLE_ENDIAN);
		buf.position(0);
//		System.out.println("-------"+buf.position());
		buf.get(x);
//		System.out.println("-------"+buf.position());
		System.out.println(x[0]+","+x[1]+","+x[2]+","+x[3]); 
//		System.out.println("-------"+buf.position());
		buf.position(0);
		System.out.println("-------"+buf.position());
		/*for (byte b : x)
		{
			System.out.println(b);
		}*/
		System.out.println("-------"+buf.position());
		System.out.println(Integer.toHexString(buf.getInt()));
		System.out.println(Integer.toHexString(buf.getChar()));
		System.out.println(Long.toHexString(buf.getLong()));
		System.out.println(buf.getDouble());
	}
}
