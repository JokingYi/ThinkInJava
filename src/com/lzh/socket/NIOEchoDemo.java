package com.lzh.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOEchoDemo
{
	public static final int PORT = 9000;

	public static void main(String[] args)
	{
		NIOEchoDemo demo = new NIOEchoDemo();
		demo.target();
	}

	public void target()
	{
		try
		{
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(PORT));
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("listenning...");
			while (true)
			{
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext())
				{
					SelectionKey key = iterator.next();
					iterator.remove();
					if (key.isAcceptable())
					{
						register(selector, serverSocketChannel);
					}
					if (key.isReadable())
					{
						echo(key);
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void register(Selector selector, ServerSocketChannel serverSocketChannel)
	{
		System.out.println("is acceptable");
		SocketChannel client;
		try
		{
			client = serverSocketChannel.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void echo(SelectionKey key) throws IOException
	{
		ByteBuffer buffer = ByteBuffer.allocate(256);
		SocketChannel channel = (SocketChannel) key.channel();
		channel.read(buffer);
		String message = new String(buffer.array());
		if ("".equals(message))
			return;
		System.out.println("is readable");
		if ("exit".equalsIgnoreCase(message))
		{
			channel.close();
			System.out.println("channel closed");
			return;
		}
		buffer.flip();
		channel.write(buffer);
	}
}
