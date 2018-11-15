package com.lzh.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient
{
	private static SocketChannel client;
	public NIOClient()
	{
		try
		{
			client=SocketChannel.open(new InetSocketAddress("localhost", NIOEchoDemo.PORT));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		NIOClient nioClient=new NIOClient();
		nioClient.sendMessage("hello");
		nioClient.sendMessage("byebye");
		nioClient.sendMessage("exit");
	}
	public void sendMessage(String message)
	{
		ByteBuffer buffer=ByteBuffer.wrap(message.getBytes());
		try
		{
			getClient().write(buffer);
			buffer.clear();
			getClient().read(buffer);
			String response=new String(buffer.array());
			System.out.println("response: "+response);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static SocketChannel getClient()
	{
		return client;
	}
}
