package com.lzh.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Image2Byte
{

	public static void main(String[] args) throws IOException
	{
		InputStream inputStream=new BufferedInputStream(
				new FileInputStream("C:/Users/ASUS/Desktop/image.jpg"));
		int count, flag=10;
		while((count=inputStream.read())!=-1 && --flag != 0)
		{
			System.out.println((char)count);
		}
	}

}
