package com.lzh.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class DatagramSocketClientDemo
{
	public static void main(String[] args)
	{
		DatagramSocket socket=null;
		try
		{
			socket=new DatagramSocket();
			byte[] data="tes".getBytes("utf8");
			System.out.println("length: "+data.length);
	 		DatagramPacket packet=new DatagramPacket(data, data.length);
	 		packet.setSocketAddress(new InetSocketAddress("localhost",DatagramSocketServerDemo.PORT));
	 		socket.send(packet);
	 		
		} catch (SocketException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			if (socket!=null)
				socket.close();
		}
		
 		
	}
}
