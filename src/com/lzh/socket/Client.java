package com.lzh.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Client
{
	
	public static void main(String[] args)
	{
		try
		{	
			Socket socket=new Socket("192.168.8.120", 60000);
			System.out.println("client created");
			
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			
			BufferedReader reader=new BufferedReader(new FileReader(new File("d:/testClient.txt")));
			String string =reader.readLine();
			boolean first=true;
			while(!"end".equals(string))
			{
				if (first)
				{
					first=false;
					//
					writer.println(string);
					writer.flush();
				}
				//
				string=reader.readLine();
				writer.println(string);
				System.out.println(string);
				writer.flush();
			}
			reader.close();
			
			System.out.println("waiting the writer to be closed in 3 seconds");
			TimeUnit.SECONDS.sleep(5);
			writer.close();
			
			socket.close();
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
