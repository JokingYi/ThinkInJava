package com.lzh.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LatchDemo {
	public static void main(String[] args) throws InterruptedException {
		LatchDemo demo=new LatchDemo();
		demo.basic();
	}
	public void basic() throws InterruptedException {
		int length=3;
		CountDownLatch startLatch=new CountDownLatch(1);
		CountDownLatch endLatch=new CountDownLatch(length);
		for (int i = 0; i < length; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						startLatch.await();
						System.out.println("started");
						TimeUnit.SECONDS.sleep(new Random().nextInt(3));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						endLatch.countDown();
					}
				}
			}).start();
		}
		long startTime=System.currentTimeMillis();
		startLatch.countDown();
		endLatch.await();
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
