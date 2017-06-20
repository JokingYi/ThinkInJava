package com.lzh.socket;

import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
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
			System.out.println("�ͻ��������ɹ�");
			
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			
			BufferedReader reader=new BufferedReader(new FileReader(new File("d:/testClient.txt")));
			String string =reader.readLine();
			boolean first=true;
			while(!"end".equals(string))
			{
				if (first)
				{
					first=false;
					//���������ϵͳ����
					writer.println(string);
					writer.flush();
				}
				//���������ϵͳ����
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
