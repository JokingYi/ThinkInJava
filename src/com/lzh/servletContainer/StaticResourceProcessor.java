package com.lzh.servletContainer;

public class StaticResourceProcessor
{
	public void processor(Request request, Response response)
	{
		response.sendStaticResource();
	}
}
