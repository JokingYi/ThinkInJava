package com.lzh.aboutClassLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.servlet.Servlet;

public class ClassLoaderDemo
{
	public static void main(String[] args)
	{
		URLClassLoader loader=null;
		URL[] urls=new URL[1];
		//F:/Êé¼®ÎÄµµ/HowTomcatWorks/webroot/
		String repository="F:/Programming/EclipseGit/ThinkInJava/webroot/";
		Class myClass=null;
		try
		{
			urls[0]=new URL("file", null, repository);
			loader=new URLClassLoader(urls);
			myClass=loader.loadClass("PrimitiveServlet");
		} catch (MalformedURLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			Servlet servlet=(Servlet) myClass.newInstance();
			System.out.println(servlet.getServletInfo());
		} catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
 		
		/*
		ClassLoader loader=ClassLoaderDemo.class.getClassLoader();
		while(loader!=null)
		{
			System.out.println(loader);
			loader=loader.getParent();
		}
		System.out.println(loader);
		*/
		/*
		URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (URL url : urls)
		{
			System.out.println(url.toExternalForm());
		}
		*/
	}
}
