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
		
		//����ͨ����һ���߳������ã������������һ���߳�ִ�е�
		System.gc();
		System.runFinalization();
		
		System.out.println(queue.poll()==pBook);
		
	}
}
