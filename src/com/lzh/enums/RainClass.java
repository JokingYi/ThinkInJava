package com.lzh.enums;

/**
 * ö�ٱ����Ϊ����ģʽ
 * @author ASUS
 *
 */
public enum RainClass
{
	MIN("its small"),
	MINIMUN("its minium"),
	MAX("its pretty big one");
	private String des;
	private RainClass(String des)
	{
		this.des=des;
	}
	public void getDes()
	{
		System.out.println(des);
	}
	@Override
	public String toString()
	{
		return des;
	}
	public static void main(String[] args)
	{
		for (RainClass rainClass : RainClass.values())
		{
			//����������ͬ����
//			rainClass.getDes();
			System.out.println(rainClass);
		}
	}
}
