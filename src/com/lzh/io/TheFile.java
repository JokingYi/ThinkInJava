package com.lzh.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TheFile
{
	public static void main(String[] args)
	{
		BufferedOutputStream stream=null;
		try
		{
			stream = new BufferedOutputStream(
					new FileOutputStream(new File("d:", "test.txt")));
			stream.write(1);
			System.out.println("down");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if (stream!=null)
				{
					stream.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
