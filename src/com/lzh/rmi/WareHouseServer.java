package com.lzh.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * ��������£�Ӧ�ý��������Ϳͻ��˵���ֱ��������Ŀ¼
 * ����Ӧ�ö�Ӧ����һ����ͬ�Ľӿ�
 * @author ASUS
 *
 */
public class WareHouseServer
{
	public static void main(String[] args) throws RemoteException, NamingException
	{
		System.out.println("constructing server implementation...");
		WareHouseImpl impl=new WareHouseImpl();
		Context namingContext=new InitialContext();
		LocateRegistry.createRegistry(1099);
		System.out.println("binding server implementation to registry...");
		namingContext.bind("rmi:central_warehouse", impl);
		System.out.println("waiting for invocations from clients");
	}
}
