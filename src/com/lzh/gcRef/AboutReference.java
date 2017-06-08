package com.lzh.gcRef;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import com.lzh.model.Book;

public class AboutReference
{
	public static void main(String[] args)
	{
		Book mBook=new Book("Walle", 0f);
//		SoftReference<Book> book=new SoftReference<Book>(mBook);
//		System.out.println(book.get());
		
		ReferenceQueue<Book> queue=new ReferenceQueue<>();
		PhantomReference<Book> pBook=new PhantomReference<Book>(mBook, queue);
//		System.out.println(pBook.get());//null
		mBook=null;
		
		//不用通过另一个线程来调用，本身就是在另一个线程执行的
		System.gc();
		System.runFinalization();
		
		System.out.println(queue.poll()==pBook);
		
	}
}
