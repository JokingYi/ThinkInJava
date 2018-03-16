package com.lzh.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recv
{
	private static final String QUEUE_NAME="hello";
	public static void main(String[] args) throws IOException, TimeoutException
	{
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel =connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("waiting for messages...");
		Consumer consumer=new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
					AMQP.BasicProperties properties, byte[] body) 
							throws IOException 
			{
				System.out.println("processing started");
				String message=new String(body, "utf-8");
				doTask(message);
				System.out.println("received "+message);
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
	private static void doTask(String task)
	{
		for (char ch: task.toCharArray())
		{
			if (ch=='.')
			{
				try
				{
					Thread.sleep(100);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
