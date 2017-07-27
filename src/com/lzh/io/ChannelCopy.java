package com.lzh.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * as the name suggested
 * @author ASUS
 *
 */
public class ChannelCopy
{
	private static final int SIZE=100;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		
		FileChannel in=new FileInputStream("d:/root.txt").getChannel(),
				out=new FileOutputStream("d:/copy.txt").getChannel();
		
		//method2
		in.transferTo(0, in.size(), out);
		//method1
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		while(in.read(buffer)!=-1)
		{
			buffer.flip();
			out.write(buffer);
			buffer.clear();
			System.out.println("test");
		}
		out.close();
		in.close();
	}
}
