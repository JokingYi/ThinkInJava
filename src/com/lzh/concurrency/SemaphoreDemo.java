package com.lzh.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {
		SemaphoreDemo demo=new SemaphoreDemo();
		demo.interrupt();
	}
	public void interrupt() throws InterruptedException {
		Semaphore semaphore=new Semaphore(0);
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("acquire");
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		TimeUnit.MILLISECONDS.sleep(500);
		thread.interrupt();
	}
	public void zero() throws InterruptedException {
		Semaphore semaphore=new Semaphore(0);
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.submit(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("acquire a lock");
					semaphore.acquire();
					System.out.println("get lock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			}
		});
		service.submit(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					semaphore.release();//increment the count, without acquire one
					System.out.println("release a lock");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		service.shutdown();
		System.out.println("shutdown fired");
		service.awaitTermination(2, TimeUnit.SECONDS);
	}
	public void basic() throws InterruptedException {
		Semaphore semaphore=new Semaphore(1);
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.execute(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println("first: get semaphore");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
					System.out.println("first: released");
				}
			}
		});
		service.execute(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
					semaphore.acquire();
					System.out.println("latter: get semaphore");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					semaphore.release();
					System.out.println("latter: release");
				}
			}
		});
		service.shutdown();
		System.out.println("shutdown signaled");
		service.awaitTermination(5, TimeUnit.SECONDS);
	}
}
