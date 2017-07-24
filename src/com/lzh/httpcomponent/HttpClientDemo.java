package com.lzh.httpcomponent;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientDemo
{
	private static class TestTask implements Runnable
	{
		private int id;
		public TestTask(int id)
		{
			this.id=id;
		}
		@Override
		public void run()
		{
			for (int i = 0; i < 10; i++)
			{
				System.out.println(Thread.currentThread().getName()
						+"#"+id);
			}
		}
	}
	private static class HttpClientTask implements Runnable
	{
		private String uri;
		CloseableHttpClient client=HttpClients.createDefault();
		private HttpGet httpGet;
		private String threadName;
		public HttpClientTask(String uri)
		{
			this.uri = uri;
			httpGet=new HttpGet(uri);
//			threadName=Thread.currentThread().getName();//不能在这里初始化，因为都是main
		}
		@Override
		public void run()
		{
			threadName=Thread.currentThread().getName();
			System.out.println(threadName+" executing request "+httpGet.getRequestLine());
			ResponseHandler<String> handler=new ResponseHandler<String>()
			{
				@Override
				public String handleResponse(HttpResponse resp) throws ClientProtocolException, IOException
				{
					int status =resp.getStatusLine().getStatusCode();
					if (status<200||status>300)
					{
						System.out.println(threadName+"wrong");
						throw new ClientProtocolException("unknow status code!");
					}else
					{
						HttpEntity entity=resp.getEntity();
						return entity!=null?EntityUtils.toString(entity, Charset.forName("utf-8")):null;
					}
				}
			};
			try
			{
				String respBody=client.execute(httpGet, handler);
				System.out.println(threadName+"-----------");
				System.out.println(threadName+"--"+respBody);
				
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			finally {
				try
				{
					client.close();
				} catch (IOException e)
				{
					System.out.println("error in close client!");
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args)
	{
		ExecutorService service=Executors.newFixedThreadPool(5);
		String uri="http://localhost:8080/android/HelloWorld";
		for(int i=0;i<5;i++)
		{
			service.execute(new HttpClientTask(uri));
		}
		service.shutdown();
	}
}
