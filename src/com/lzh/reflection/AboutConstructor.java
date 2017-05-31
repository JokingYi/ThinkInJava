package com.lzh.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.lzh.model.Book;

public class AboutConstructor
{
	
	public static void main(String[] args)
	{
		try
		{
			Constructor<Book> constructor=Book.class.getConstructor(String.class, float.class);
			Object book=constructor.newInstance("bookname", new Float(12.3));//原始数据类型得用相应的包装类
			Book book2=(Book) book;
			System.out.println(book2.toString());
		} catch (NoSuchMethodException | SecurityException e)
		{
			System.out.println("failed to get Construtor");
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}

}
