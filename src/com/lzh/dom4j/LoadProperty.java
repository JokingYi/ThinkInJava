package com.lzh.dom4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadProperty
{
	public static void main(String[] args)
	{
		InputStream inputStream=
				ClassLoader.getSystemResourceAsStream("testConfig.xml");
		BufferedInputStream bufferedStream=new BufferedInputStream(inputStream);
		int i;
		try
		{
			while((i=bufferedStream.read())!=-1)
			{
				System.out.print((char) i);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
