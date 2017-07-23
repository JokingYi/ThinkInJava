package com.lzh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WareHouse extends Remote
{
	double getPrice(String des) throws RemoteException;
}	
