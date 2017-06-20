package com.lzh.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class CopyFile
{
	public static Tester[] testers={
			new Tester("copy test.pic without buffer")
			{
				
				@Override
				public void test()
				{
					FileInputStream fi=null;
					FileOutputStream fo=null;
					try
					{
						fi=new FileInputStream("d:/test.jpg");
						fo=new FileOutputStream("d:/test2.jpg");
						byte[] buffer=new byte[1024];
						int i=fi.read(buffer);
						while(i!=-1)
						{
							fo.write(buffer, 0, i);
							i=fi.read(buffer);
						}
					} catch (FileNotFoundException e)
					{
						e.printStackTrace();
					} catch (IOException e)
					{
						e.printStackTrace();
					}finally {
						if (fi!=null)
						{
							try
							{
								fi.close();
							} catch (IOException e)
							{
								e.printStackTrace();
							}
						}
						if (fo!=null)
						{
							try
							{
								fo.close();
							} catch (IOException e)
							{
								e.printStackTrace();
							}
						}
					}
				}
			},
			new Tester("copy test.jpg with buffer")
			{
				@Override
				public void test()
				{
					BufferedInputStream bi=null;
					BufferedOutputStream bo=null;
					try
					{
						bi=new BufferedInputStream(
								new FileInputStream(
										new File("d:/test.jpg")));
						bo=new BufferedOutputStream(
								new FileOutputStream(
										new File("d:/test3.jpg")));
						byte[] buffer=new byte[1024];
						int i=bi.read(buffer);
						while(i!=-1)
						{
							bo.write(buffer, 0, i);
							i=bi.read(buffer);
						}
					} catch (FileNotFoundException e)
					{
						e.printStackTrace();
					} catch (IOException e)
					{
						e.printStackTrace();
					}finally {
						try
						{
							bi.close();
							bo.close();
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
	};
	
	private abstract static class Tester
	{
		private String name;
		public Tester(String name)
		{
			this.name = name;
		}
		
		public void run()
		{
			long start=System.nanoTime();
			test();
			double duration=(System.nanoTime()-start)/1.0E9;
			DecimalFormat format=new DecimalFormat("0.0000");
			System.out.println(name+" : "+format.format(duration));
		}
		
		public abstract void test();
	}
	
	public static void main(String[] args)
	{
		for (Tester tester : testers)
		{
			tester.run();
		}
	}
}
