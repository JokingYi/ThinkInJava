package com.lzh.io.charset;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

import org.junit.Test;

public class FileCharsetTest
{
	@Test
	public void testChar()
	{
		char sQuote='\'';
		System.out.println((int)sQuote);
	}
	
//	@Test
	public void testReadWithReader()
	{
		String sourcePath="D:\\test\\testCharset.txt";
		String targetPath="D:\\test\\testCharsetCopy.txt";
		
		Reader reader=null;
		Writer writer=null;
		try
		{
			reader=new BufferedReader(new InputStreamReader(
					new FileInputStream(sourcePath), Charset.forName("utf-8")));
			writer=new BufferedWriter(new FileWriter(targetPath));
			while(true)
			{
				char[] buffer=new char[32];
				int count=reader.read(buffer);
				if(count==-1)
					break;
				writer.write("\t english");
				writer.write(buffer, 0, count);
			}
		} catch (FileNotFoundException e)
		{
			fail();
			e.printStackTrace();
		} catch (IOException e)
		{
			fail();
			e.printStackTrace();
		}finally
		{
				try
				{
					if(reader!=null)
						reader.close();
					if(writer!=null)
						writer.close();
				} catch (IOException e)
				{
					fail();
					e.printStackTrace();
				}
		}
	}
	
//	@Test
	public void testReadWithInputstream()
	{
		String sourcePath="D:\\test\\testCharset.txt";
		String targetPath="D:\\test\\testCharsetCopy.txt";
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try
		{
			inputStream=new BufferedInputStream(new FileInputStream(sourcePath));
			outputStream=new BufferedOutputStream(new FileOutputStream(targetPath));
			
			byte[] buffer=new byte[64];
			while(true)
			{
				int count=inputStream.read(buffer);
				if(count==-1)
					break;
				outputStream.write("\t english".getBytes(Charset.forName("utf-8")));
				outputStream.write(buffer, 0, count);
			}
		} catch (FileNotFoundException e)
		{
			fail();
			e.printStackTrace();
		} catch (IOException e)
		{
			fail();
			e.printStackTrace();
		}finally{
				try
				{
					if(inputStream!=null)
						inputStream.close();
					if(outputStream!=null)
						outputStream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}

}
