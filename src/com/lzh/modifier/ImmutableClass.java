package com.lzh.modifier;

import com.lzh.model.Book;

public class ImmutableClass
{
	private final Book book;
	private String string;

	public ImmutableClass(Book book, String string)
	{
//		this.book = book;//if so, than this class is a mutable class
		this.book=new Book(book.getName(), book.getPrice());
		this.string=string;
	}
	public Book getBook()
	{
		return new Book(book.getName(), book.getPrice());
	}
	public String getString()
	{
		return string;
	}

	public static void main(String[] args)
	{
		// 有关该不变类的测试
		Book book=new Book("first", 2f);
		String test="test";
		ImmutableClass im=new ImmutableClass(book, test);
		
//		book.setName("later");
//		System.out.println(im.getBook().getName());//first
		
		test="test again";
		System.out.println(im.getString());//test
	}
}
