package com.lzh.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javax.sound.sampled.Port;

import com.mysql.fabric.Server;

public class DatagramSocketServerDemo
{
	public static final int PORT=4445;
	
	public static void main(String[] args)
	{
		try
		{
			new ServerThread().start();
		} catch (SocketException e)
		{
			e.printStackTrace();
		}
	}
}
class ServerThread extends Thread 
{
	private DatagramSocket socket=null;
	public ServerThread() throws SocketException
	{
		super("server thread");
		socket=new DatagramSocket(new InetSocketAddress("localhost",DatagramSocketServerDemo.PORT));
		System.out.println("listening...");
	}
	@Override
	public void run()
	{
		byte[] buffer=new byte[5];
		DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
		try
		{
			socket.receive(packet);
			System.out.println("date received: "+new String(packet.getData())+", from "+packet.getPort());
			System.out.println("again...");
			socket.receive(packet);
			System.out.println("date received: "+new String(packet.getData())+", from "+packet.getPort());
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			socket.close();
		}
		
	}
}
class LoopReceive implements Runnable 
{
	private DatagramSocket socket=null;
	public LoopReceive() throws SocketException
	{
		socket=new DatagramSocket(new InetSocketAddress("localhost",DatagramSocketServerDemo.PORT));
		System.out.println("listening...");
	}
	@Override
	public void run()
	{
		
	}
	public void waitForMessage()
	{
	}
}
