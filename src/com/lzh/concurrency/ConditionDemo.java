package com.lzh.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	public static void main(String[] args) {
		ConditionDemo demo=new ConditionDemo();
		demo.basic2();
	}
	public void basic() {
		ReentrantLock lock=new ReentrantLock();
		Condition condition1=lock.newCondition();
		Condition condition2=lock.newCondition();
		System.out.println(condition1==condition2);//false
	}
	//throw exception
	public void basic2() {
		ReentrantLock lock=new ReentrantLock();
		Condition condition =lock.newCondition();
		try {
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void producerConsumer() {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		BoundedBuffer buffer=new BoundedBuffer();
		executor.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						buffer.put(i+"");
						System.out.println("produce: "+i);
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		executor.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						System.out.println("consumer get: "+buffer.take());
						TimeUnit.MILLISECONDS.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		executor.shutdown();
	}
	public void waitAndAwait() {
		Lock lock=new ReentrantLock();
		Condition condition=lock.newCondition();
		IntWrapper intWrapper=new IntWrapper();
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.execute(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					System.out.println("wait started");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("sleep end");
					while(intWrapper.number==0){
						condition.await();//should not use wait
					}
					System.out.println("wait ended");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		});
		service.execute(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					intWrapper.number=1;
					condition.signal();
					System.out.println("signal end");
				} finally {
					lock.unlock();
				}
			}
		});
		service.shutdown();
	}
	class IntWrapper{
		int number;
	}
	/*ArrayBlockingQueue*/
	class BoundedBuffer{
		Lock lock=new ReentrantLock();
		Condition notFull=lock.newCondition();
		Condition notEmpty=lock.newCondition();
		
		String[] buffer=new String[10];
		int putCount, takeCount, count;
		
		public void put(String message) throws InterruptedException {
			lock.lock();
			try{
				while(count==buffer.length){
					notFull.await();
				}
				buffer[putCount++]=message;
				if(putCount==buffer.length) putCount=0;
				count++;
				notEmpty.signal();
			}finally {
				lock.unlock();
			}
		}
		public String take() throws InterruptedException {
			lock.lock();
			try {
				while(count==0){
					notEmpty.await();
				}
				String string=buffer[takeCount++];
				if(takeCount==buffer.length) takeCount=0;
				count--;
				notFull.signal();
				return string;
			} finally {
				lock.unlock();
			} 
		}
	}
}
