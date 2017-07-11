package com.lzh.servletContainer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServer1
{
	private static final String SHUTDOWN_COMMAND="/shutdown";
	private boolean shutdown=false;
	
	public void await()
	{
		ServerSocket serverSocket=null;
		try
		{
			serverSocket=new ServerSocket(8080, 1, 
					InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		while(!shutdown)
		{
			Socket socket=null;
			InputStream inputStream=null;
			OutputStream outputStream=null;
			try
			{
				socket=serverSocket.accept();
				inputStream=socket.getInputStream();
				outputStream=socket.getOutputStream();
				
				Request request=new Request(inputStream);
				request.parse();
				
				Response response=new Response(outputStream);
				response.setRequest(request);
				
				if (request.getUri().startsWith("/servlet/"))
				{
					ServletProcessor1 processor1=new ServletProcessor1();
					processor1.process(request, response);
				}else
				{
					StaticResourceProcessor processor2=new StaticResourceProcessor();
					processor2.processor(request, response);
				}
				
				socket.close();
				shutdown=request.getUri().equals(SHUTDOWN_COMMAND);
			} catch (IOException e)
			{
				e.printStackTrace();
				//good point
				continue;
			}
		}
	}
	
	public static void main(String[] args)
	{
		new HttpServer1().await();
	}
}
