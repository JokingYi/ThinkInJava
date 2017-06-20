package com.lzh.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TheBufferedInputStream
{
	public static void main(String[] args)
	{
		BufferedInputStream bstream=null;
		try
		{
			bstream=new BufferedInputStream(
					new FileInputStream("d:/test.txt"));
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			System.out.println("mark method invoked");
			bstream.mark(0);
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			bstream.reset();
			System.out.println("reseted");
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			bstream.reset();
			System.out.println("reseted");
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			System.out.println((char) bstream.read());
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			if (bstream!=null)
			{
				try
				{
					bstream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
				
		}
	}
}
