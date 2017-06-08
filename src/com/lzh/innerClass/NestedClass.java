package com.lzh.innerClass;

public class NestedClass
{
	private void print()
	{
		System.out.println("private method in class");
	}
		
	//���Դ���������ã������������ⲿ��
	public static class InClass
	{
		private String test;
		public InClass()
		{
			test="default";
		}
		public InClass(String test)
		{
			this.test = test;
		}
		@Override
		public String toString()
		{
			return test;
		}
	}
	//���������ⲿ�������
	public class InClass2
	{
		private String test2;
		public InClass2()
		{
			test2="";
		}
		@Override
		public String toString()
		{
			//��Ϊ�������ⲿ���ӣ����Կ���ֱ�ӵ����ⲿ��ķ�����������private����,��ʵ����������һ�����������������private������
			print();
			return test2;
		}
	}
}
