package com.lzh.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WareHouseImpl extends UnicastRemoteObject implements WareHouse
{
	private Map<String, Double> prices;
	private static final long serialVersionUID = 1L;
	public WareHouseImpl() throws RemoteException
	{
		System.out.println("constructor in impl");
		prices=new HashMap<String, Double>();
		prices.put("key1", 13.4);
		prices.put("key2", 26.8);
	}

	@Override
	public double getPrice(String des) throws RemoteException
	{
		Double price=prices.get(des);
		return price==null?0:price;
	}
	
}
