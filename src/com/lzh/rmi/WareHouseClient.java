package com.lzh.rmi;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

/**
 * ��������£�Ӧ�ý��������Ϳͻ��˵���ֱ��������Ŀ¼
 * ����Ӧ�ö�Ӧ����һ����ͬ�Ľӿ�
 * @author ASUS
 *
 */
public class WareHouseClient
{
	public static void main(String[] args) throws NamingException
	{
		Context namingContext=new InitialContext();
		System.out.println("rmi registry binding");
		Enumeration<NameClassPair> e= namingContext.list("rmi://localhost/");
		while (e.hasMoreElements())
		{
			NameClassPair nameClassPair = (NameClassPair) e.nextElement();
			System.out.println(nameClassPair.getName());
		}
		String url="rmi://localhost/central_warehouse";
		WareHouse house=(WareHouse) namingContext.lookup(url);
		
		String des="key1";
		double price=0;
		try
		{
			price = house.getPrice(des);
		} catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		System.out.println(des+": "+price);
	}
}
