package com.lzh.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class MappedIo
{
	private static int numOfInts=4000000;
	private static int numOfUbuffInts=200000;
	private abstract static class Tester
	{
		private String name;
		public Tester(String name)
		{
			this.name = name;
		}
		public void runTest()
		{
			System.out.print(name+": ");
			try
			{
				long start=System.nanoTime();
				test();
				double duration=System.nanoTime()-start;
				System.out.format("%.2f\n", duration/1.0e9);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		public abstract void test() throws IOException;
		
	}
	private static Tester[] testers=
		{
			new Tester("stream write")
			{
				@Override
				public void test() throws IOException
				{
					DataOutputStream dataOutputStream=new DataOutputStream(
							new BufferedOutputStream(new FileOutputStream(
									"d:/tempInt.txt")));
					for (int i = 0; i < numOfInts; i++)
					{
						dataOutputStream.write(i);
					}
					dataOutputStream.close();
				}
			},
			new Tester("")
			{
				
				@Override
				public void test() throws IOException
				{
					
				}
			}, 
			new Tester("mapped write")
			{
				@Override
				public void test() throws IOException
				{
					@SuppressWarnings("unused")
					FileChannel channel=new RandomAccessFile("d:/tempInt.txt", "rw").getChannel();
					IntBuffer buffer=channel.map(FileChannel.MapMode.READ_WRITE, 0, 4*channel.size()).asIntBuffer();
					int i = 0;
					try
					{
						for (i=0; i < numOfInts; i++)
						{
							buffer.put(i);
						}
					} catch (Exception e)
					{
						System.out.println(i);
						e.printStackTrace();
					}
					channel.close();
				}
			}
		};
	public static void main(String[] args)
	{
		
	}
}
