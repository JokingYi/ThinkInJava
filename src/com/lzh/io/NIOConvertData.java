package com.lzh.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * always be careful about char
 * for its needed to encode them when turn them into characters
 * and(usually) decode them out as they come out of the buffer
 * @author ASUS
 *
 */
public class NIOConvertData
{
	public static void main(String[] args)
	{
//		System.out.println(System.getProperty("file.encoding"));
		
		FileChannel channel=null;
		try
		{
			channel=new FileOutputStream("d:/test.txt").getChannel();
			channel.write(ByteBuffer.wrap("abcd".getBytes("utf-8")));
			channel.close();
			ByteBuffer buffer=ByteBuffer.allocate(12);
			channel=new FileInputStream("d:/test.txt").getChannel();
			buffer.clear();
			channel.read(buffer);
			buffer.flip();
			System.out.println(Charset.forName("utf-8").decode(buffer));
//			System.out.println(buffer.asCharBuffer());
//			CharBuffer charBuffer=buffer.asCharBuffer();
//			System.out.println(charBuffer.get());
			channel.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
