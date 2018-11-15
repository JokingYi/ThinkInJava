package com.lzh.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class MapFamily
{

//	@Test
	public void testMap() throws IOException
	{
		Hashtable<String, String> hashtable=new Hashtable<>();
		hashtable.put("1", "2");
		hashtable.put("1", "2");
		HashMap<String, String> hashMap;
		ConcurrentHashMap<String, String> concurrentHashMap;
		CopyOnWriteArrayList<String> strings;
		CountDownLatch latch;
		FutureTask<String> task;
		Future<String> future;
		ServerSocket socket=new ServerSocket(80);
		socket.accept();
		Executor executor;
		Timer timer=null;
		new Thread().suspend();
	}
	@Test
	public void testNullMap()
	{
		HashMap<String, String> map=new HashMap<>();
		map.put(null, "string");
		map.put(null, "string2");//over-write
		System.out.println(map);
	}
}
