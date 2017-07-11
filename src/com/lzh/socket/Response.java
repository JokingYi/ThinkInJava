package com.lzh.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response
{
	private static final int BUFFER_SIZE=1024;
	private Request request;
	private OutputStream output;
	
	public Response(OutputStream output)
	{
		this.output = output;
	}
	public void setRequest(Request request)
	{
		this.request=request;
	}
	public void sendStaticResource()
	{
		byte[] bytes=new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		
		File file=new File(HttpServer.WEB_ROOT, request.getUri());
		
		try
		{
			if (file.exists())
			{
				fis=new FileInputStream(file);
				String header="HTTP/1.1 200 OK\r\n"
						+ "Content-Type: text/plain\r\n"
						+ "Content-length: \r\n"
						+ "Connection: close\r\n"
						+ "\r\n";
				output.write(header.getBytes());
				int ch=fis.read(bytes, 0, BUFFER_SIZE);
				while(ch!=-1)
				{
					output.write(bytes, 0, ch);
					ch=fis.read(bytes, 0, BUFFER_SIZE);
				}
			}else 
			{
				String errorMessage="HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Content-length: 23\r\n"
						+ "Connection: close\r\n"
						+ "\r\n"
						+ "<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if (fis!=null)
			{
				try
				{
					fis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
