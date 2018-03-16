package com.lzh.io;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.Random;

import org.apache.tomcat.util.net.Nio2Endpoint.Nio2SocketWrapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class NIODemo
{
	public static final int SIZE=1024;
	private File file;
	@Rule
	public TemporaryFolder folder=new TemporaryFolder();
	@Before
	public void setUp() throws IOException
	{
		file=folder.newFile();
	}
//	@Test
	public void testRandomAccessFile() throws IOException
	{
		PrintWriter writer=new PrintWriter(new FileOutputStream(file));
		writer.write("for test");
		writer.close();
		RandomAccessFile accessFile=new RandomAccessFile(file, "rw");
		FileChannel channel=accessFile.getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(SIZE);
		int byteRead=channel.read(buffer);
		while(byteRead!=-1)
		{
			//you need to switch the buffer from write mode to read mode
			buffer.flip();
			while(buffer.hasRemaining())
			{
				System.out.println((char)buffer.get());
			}
			buffer.clear();
		}
		accessFile.close();
	}
//	@Test
	public void testOutputFileChannel()
	{
		file=new File("C:\\Users\\ASUS\\Desktop\\temp.txt");
		FileOutputStream fileOutputStream=null;
		FileChannel fileChannel=null;
		ByteBuffer byteBuffer=ByteBuffer.allocate(64);
		byte[] src={'h', 'e', 'l', 'l', 'o'};
		try
		{
			fileOutputStream=new FileOutputStream(file, true);
			fileChannel=fileOutputStream.getChannel();
			byteBuffer.put(src);
			byteBuffer.flip();
			fileChannel.write(byteBuffer);
			byteBuffer.clear();
			//can not read from a outputstream
//			fileChannel.read(byteBuffer);
//			assertEquals("testhello", byteBuffer.toString());
			//
			fileChannel.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			closeStream(fileOutputStream);
		}
	}
//	@Test
	public void testScatter()
	{
		file=new File("C:\\Users\\ASUS\\Desktop\\temp.txt");//"hello"
		FileInputStream inputStream=null;
		ByteBuffer buffer1=ByteBuffer.allocate(2);
		ByteBuffer buffer2=ByteBuffer.allocate(3);
		ByteBuffer[] src={buffer1, buffer2};
		try
		{
			inputStream = new FileInputStream(file);
			FileChannel fileChannel=inputStream.getChannel();
			//we need to know the byte count for each part before hand
			fileChannel.read(src);
			buffer1.flip();
			buffer2.flip();
			assertEquals("he", new String(buffer1.array()));
			assertEquals("llo", new String(buffer2.array()));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally{
			closeStream(inputStream);
		}
	}
//	@Test
	public void testTransfer() throws IOException
	{
		file=new File("C:\\Users\\ASUS\\Desktop\\temp.txt");//"hello"
		File toFile=new File("C:\\Users\\ASUS\\Desktop\\temp_copy.txt");
		RandomAccessFile randomAccessFile2=new RandomAccessFile(toFile, "rw");
		FileChannel toChannel=randomAccessFile2.getChannel();
		RandomAccessFile randomAccessFileFrom=new RandomAccessFile(file, "rw");
		FileChannel fromChannel=randomAccessFileFrom.getChannel();
		toChannel.transferFrom(fromChannel, 0, fromChannel.size());
		closeStream(randomAccessFile2);
		closeStream(randomAccessFileFrom);
	}
//	@Test
	public void testHashCode()
	{
		Temp temp=new Temp();
		System.out.println(temp.hashCode());
		temp.name="haha";
		System.out.println(temp.hashCode());
	}
	protected static void closeStream(Closeable closeable)
	{
		if(closeable!=null)
			try
			{
				closeable.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	private static class Temp
	{
		private String name;
	}
}
