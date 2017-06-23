package com.lzh.dom4j;

import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ParseUrl
{
	public static Document parse(URL url) throws DocumentException
	{
		SAXReader reader=new SAXReader();
		Document document=reader.read(url);
		return document;
	}
	
	public static void main(String[] args)
	{
		try
		{
			Document document=ParseUrl.parse(new URL("file:///F:/Programming/webstormProject/JSproject/First.html"));
			System.out.println(document.getRootElement().getName());
		} catch (MalformedURLException e)
		{
//			System.out.println("do not support the file protocal");
			e.printStackTrace();
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}
	}
}
