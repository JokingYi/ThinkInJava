package com.lzh.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

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
			new Tester("dataouput stream write")
			{
				@Override
				public void test() throws IOException
				{
					DataOutputStream dataOutputStream=new DataOutputStream(
							new BufferedOutputStream(new FileOutputStream(
									"d:/tempInt.txt")));
					for (int i = 0; i < numOfInts; i++)
					{
						dataOutputStream.writeInt(i);
					}
					dataOutputStream.close();
				}
			},
			 
			new Tester("mapped write")
			{
				@Override
				public void test() throws IOException
				{
					@SuppressWarnings("unused")
					FileChannel channel=new RandomAccessFile("d:/tempInt.txt", "rw").getChannel();
					IntBuffer buffer=channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size()).asIntBuffer();
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
			},
			new Tester("stream read")
			{
				@Override
				public void test() throws IOException
				{
					DataInputStream inputStream=new DataInputStream(
							new BufferedInputStream(
									new FileInputStream("d:/tempInt.txt")));
					for(int i=0;i<numOfInts;i++)
					{
						inputStream.readInt();
					}
					inputStream.close();
				}
			},
			new Tester("simple circle")
			{
				
				@Override
				public void test() throws IOException
				{
					for(int i=0; i<numOfInts;i++)
					{
						
					}
				}
			}	
		};
	public static void main(String[] args)
	{
		for (Tester tester : testers)
		{
			tester.runTest();
		}
	}
}
