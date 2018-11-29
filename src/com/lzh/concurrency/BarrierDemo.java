package com.lzh.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
	public static void main(String[] args) {
		BarrierDemo demo=new BarrierDemo();
		demo.cyclicDemo();
	}
	public void cyclicDemo() {
		CyclicBarrier barrier=new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("all task finished");
			}
		});
		new Thread(new PrintTask(2, barrier)).start();
		new Thread(new PrintTask(3, barrier)).start();
	}
	class PrintTask implements Runnable{
		int seconds;
		CyclicBarrier barrier;
		public PrintTask(int seconds, CyclicBarrier barrier) {
			this.seconds = seconds;
			this.barrier=barrier;
		}
		@Override
		public void run() {
			try {
				System.out.println("start task: "+seconds);
				TimeUnit.SECONDS.sleep(seconds);
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
