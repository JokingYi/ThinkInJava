package com.lzh.socket;

import java.io.IOException;
import java.io.InputStream;

public class Request
{
	private InputStream inputStream;
	private String uri;
	public Request(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}
	public void parse()
	{
		StringBuffer request=new StringBuffer();
		int i;
		byte[] buffer=new byte[2048];
		try
		{
			i=inputStream.read(buffer);
		} catch (IOException e)
		{
			e.printStackTrace();
			i=-1;
		}
		for (int j = 0; j < i; j++)
		{
			request.append((char) buffer[j]);
		}
		System.out.println(request.toString());
		uri=parseUri(request.toString());
	}
	private String parseUri(String requestString)
	{
		int index1, index2;
		index1=requestString.indexOf(' ');
		if(index1!=-1)
		{
			index2=requestString.indexOf(' ', index1+1);
			if(index2>index1)
				return requestString.substring(index1+1, index2);
		}
		return null;
	}
	public String getUri()
	{
		return uri;
	}

	public static void main(String[] args)
	{
		/*
		//just a little test about "inputstream"
		InputStream inputStream=null;
		byte[] buffer=new byte[512];
		int index;
		StringBuilder text=new StringBuilder();
		
		try
		{
			inputStream=new BufferedInputStream(
					new FileInputStream(
							new File("d:/root.txt")));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			index=inputStream.read(buffer, 0, 512);
			while(index!=-1)
			{
				text.append(new String(buffer));
				index=inputStream.read(buffer, 0, 512);
			}
			System.out.println(text.toString());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		*/
	}
}
