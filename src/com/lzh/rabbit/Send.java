package com.lzh.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send
{
	private final static String QUEUE_NAME="hello";
	
	public static void main(String[] args) throws IOException, TimeoutException
	{
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
//		channel.queueDelete(QUEUE_NAME);
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//		String message="Hello World";
		//try with multiple task
		String[] messages=getMessage();
		for (String message : messages)
		{
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("Sent: "+message);
		}
		channel.close();
		connection.close();
	}
	private static String[] getMessage()
	{
		String[] strings={
		       			"first task.",
		    			"second task..",
		    			"third task...",
		    			"forth task...."
		    		};
		return strings;
	}
}
