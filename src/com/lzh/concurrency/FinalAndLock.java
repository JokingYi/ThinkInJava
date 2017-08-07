package com.lzh.concurrency;

class MyField
{
	public void method1() 
	{
		try
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("method1 complete!");
	}
	public void method2()
	{
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("method2 complete!");
	}
}
public class FinalAndLock
{
	//implicit lock with final field
	public final MyField field;
	public static MyField field2=new MyField();
	public MyField field3=new MyField();
	
	public FinalAndLock(MyField field)
	{
		this.field = field;
	}

	public static void main(String[] args)
	{
		//test implicit lock on final fields
		//well than, no called lock in both static and final
		FinalAndLock lock=new FinalAndLock(new MyField());
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
//				lock.field.method1();				
				FinalAndLock.field2.method1();
			}
		}).start();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
//				lock.field.method2();
				FinalAndLock.field2.method2();
			}
		}).start();;
		/*FinalAndLock.field2.method1();
		FinalAndLock.field2.method2();*/
		/*FinalAndLock lock=new FinalAndLock(new MyField());
		lock.field3.method1();
		lock.field3.method2();*/
	}
	
}
