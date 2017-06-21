package com.lzh.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class DataInputStreamDemo
{
	public static void main(String[] args) throws Exception
	{
		//which means data write by the dataoutputstream can also be read by the 
		//other inputstream
		DataOutputStream writeData=new DataOutputStream(new FileOutputStream(
				new File("d:/data.txt")));
		writeData.writeInt(1);
		writeData.close();
		//read by inputstream and byteBuffer
		System.out.println("read by inputstream and bytebuffer");
		InputStream inputStream=new FileInputStream(new File("d:/data.txt"));
//		inputStream.read
		byte[] bytes=new byte[4];
		System.out.println(inputStream.read(bytes));
		inputStream.close();
		ByteBuffer buffer=ByteBuffer.wrap(bytes);
		System.out.println(buffer.getInt());
		//read by datainputstream
		System.out.println("read by datainputstream");
		DataInputStream readData=new DataInputStream(new FileInputStream(
				new File("d:/data.txt")));
		System.out.println(readData.readInt());
	}
}
