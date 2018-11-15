package com.lzh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceDemo
{
	public static void main(String[] args)
	{
		CompletionServiceDemo demo=new CompletionServiceDemo();
		demo.basic();
	}
	public void basic()
	{
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		CompletionService<ImageInfo> service=new ExecutorCompletionService<>(executor);
		List<ImageInfo> imageInfos=getImageInfos();
		for (ImageInfo info : imageInfos)
		{
			service.submit(new Callable<CompletionServiceDemo.ImageInfo>()
			{
				@Override
				public ImageInfo call() throws Exception
				{
					return info.downloadImage();
				}
			});
		}
		try
		{
			for (int i = 0; i <imageInfos.size() ; i++)
			{
				System.out.println("service take");
				Future<ImageInfo> future=service.take();//wait here
				System.out.println("service take end");
				System.out.println("future take");
				ImageInfo info=future.get();
				System.out.println("future take end");
				renderImage(info);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (ExecutionException e)
		{
			e.printStackTrace();
		}
		executor.shutdown();
	}
	public List<ImageInfo> getImageInfos()
	{
		List<ImageInfo> imageInfos=new ArrayList<>();
		imageInfos.add(new ImageInfo(500, "image800"));
		imageInfos.add(new ImageInfo(3000, "image3000"));
		imageInfos.add(new ImageInfo(1000, "image1000"));
		imageInfos.add(new ImageInfo(6000, "image6000"));
		return imageInfos;
	}
	public void renderImage(ImageInfo imageInfo)
	{
		System.out.println("render image: "+imageInfo);
	}
	class ImageInfo{
		int time;
		String name;
		public ImageInfo(int time, String name)
		{
			this.time = time;
			this.name = name;
		}
		public ImageInfo downloadImage()
		{
			try
			{
				Thread.sleep(time);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return this;
		}
		@Override
		public String toString()
		{
			return "image name: "+name+", take time: "+time;
		}
	}
}
