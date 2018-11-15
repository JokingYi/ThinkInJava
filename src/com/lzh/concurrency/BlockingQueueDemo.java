package com.lzh.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueDemo demo=new BlockingQueueDemo();
		demo.blockingDemo1Cap();
	}
	/**
	 * SynchronousQueue output count double the count output by linkedBlockingQueue, and ArrayBlockingQueue
	 * @throws InterruptedException
	 */
	public void blockingDemo1Cap() throws InterruptedException {
		BlockingQueue<String> syncQueue=new LinkedBlockingQueue<>(1);//change implementation for linkedQueue or arrayQueue
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(new Runnable() {
			@Override
			public void run() {
				try {
					while(true)
						syncQueue.put("1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("put finish");
				}
			}
		});
		service.submit(new Runnable() {
			@Override
			public void run() {
				long init=System.currentTimeMillis();
				int count=0;
				try {
					while(System.currentTimeMillis()-init<=1000){
						syncQueue.take();
						count++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("take finish: "+count);//14w or so for Synchronous, 6w or so for linkedQueue and array queue
				}
			}
		});
		TimeUnit.SECONDS.sleep(2);
		service.shutdownNow();
	}
}
