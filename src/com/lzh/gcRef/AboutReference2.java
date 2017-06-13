package com.lzh.gcRef;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class AboutReference2
{
	public static void main(String[] args)
	{
		ReferenceQueue<String> queue=new ReferenceQueue<>();
		String string=new String("a");
		Reference<String> reference=new WeakReference<String>(string, queue); 
		
		System.out.println(reference.get());
		
		string=null;
		System.gc();
		try
		{
			System.out.println(reference.isEnqueued());
			System.out.println(queue.remove(2000));
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
