package com.lzh.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LockBlock {
	public synchronized void sleepTime(TimeUnit unit, long count) throws InterruptedException {
		System.out.println("enter method");
		unit.sleep(count);
	}
	public static void main(String[] args) throws InterruptedException {
		LockBlock block=new LockBlock();
		CountDownLatch start=new CountDownLatch(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("first start");
					block.sleepTime(TimeUnit.SECONDS, 5);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("first interrupted");
				}
			}
		}).start();
		Thread interThread=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					start.countDown();
					System.out.println("second start");
					block.sleepTime(TimeUnit.SECONDS, 4);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("second interrupted");
				}
			}
		});
		interThread.start();
		start.await();
		interThread.interrupt();
	}
}
