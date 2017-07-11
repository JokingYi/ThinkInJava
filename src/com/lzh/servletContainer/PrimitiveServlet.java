package com.lzh.servletContainer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet 
{
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("init");
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		System.out.println("from service1");
		Response response=(Response) res;
		OutputStream out= response.getOut();
		String header="HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/plain\r\n"
				+ "Content-length: \r\n"
				+ "Connection: close\r\n"
				+ "\r\n";
		out.write(header.getBytes());
		out.write("maybe the english first".getBytes());
		out.write("中文".getBytes(Charset.forName("utf-8")));
		
		/*
		PrintWriter out=res.getWriter();
		out.println("wei，是妖妖灵吗，有人人肉我，把我诈骗的事捅出去了");
		out.print("this cannot be printed");
		*/
		out.close();
	}

	@Override
	public String getServletInfo()
	{
		return "primitiveServlet";
	}

	@Override
	public void destroy()
	{
		System.out.println("destory");
	}
	
}
