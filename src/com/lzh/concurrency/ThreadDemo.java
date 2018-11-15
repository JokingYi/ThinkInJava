package com.lzh.concurrency;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
	public static void main(String[] args) {
		ThreadDemo demo=new ThreadDemo();
		demo.uncaugutExceptionHandlerDemo();
	}
	public void threadPoolExecutorDemo() {
		//pay attention to the diff between submit and execute
	}
	public void uncaugutExceptionHandlerDemo() {
		Thread thread=new Thread(new Runnable() {
			@SuppressWarnings("null")
			@Override
			public void run() {
				String fake=null;
				System.out.println(fake.substring(1));
			}
		});
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}
	public void dameonDemo() {
		Thread thread= new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("inner dameon thread end");//won't trigger
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		System.out.println("out end");
	}
	public void nonDameonDemo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.println("inner thread end");
				}
			}
		}).start();
		System.out.println("out end");
	}
	/**
	 * interrupt better then status flag<p>
	 * for library method like wait, sleep etc take interrupt request seriously
	 */
	public void interruptedDemo() {
		BlockingTask task=new BlockingTask(getBlockingQueue());
		task.start();
		try {
			TimeUnit.SECONDS.sleep(3);
			task.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void cancelFlagDemo() {
		BlockingTaskFlag taskFlag=new BlockingTaskFlag(getBlockingQueue());
		taskFlag.start();
		try {
			TimeUnit.SECONDS.sleep(3);
			taskFlag.isCanceled=true;
			System.out.println("sleep end");
			System.out.println("take from queue: "+taskFlag.nums.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	class BlockingTask extends Thread{
		BlockingQueue<Integer> nums;
		public BlockingTask(BlockingQueue<Integer> nums) {
			this.nums=nums;
		}
		@Override
		public void run() {
			BlockingQueue<Integer> queue=getQueue();
			System.out.println("task start");
			try {
				while(!Thread.currentThread().isInterrupted()){
					queue.put(0);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("task finish");
			}
		}
		public BlockingQueue<Integer> getQueue() {
			return nums;
		}
		public void cancel() {
			this.interrupt();
		}
	}
	class BlockingTaskFlag extends Thread{
		BlockingQueue<Integer> nums;
		boolean isCanceled=false;
		public BlockingTaskFlag(BlockingQueue<Integer> nums) {
			this.nums = nums;
		}
		@Override
		public void run() {
			System.out.println("task using flag start");
			try {
				while(!isCanceled)
					this.nums.put(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("task using flag ended");
			}
		}
	}
	//full
	public BlockingQueue<Integer> getBlockingQueue() {
		BlockingQueue<Integer> nums=new ArrayBlockingQueue<>(3);
		try {
			for (int i = 1; i < 4; i++) {
				nums.put(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nums;
	}
	/**
	 * alternative way to suspend, resume and stop thread
	 */
	public void basic() {
		PrintTaskService service=new PrintTaskService("print task");
		new Thread(service).start();
		try {
			TimeUnit.SECONDS.sleep(7);
			System.out.println("main thread wake up!");
			System.out.println("suspend");
			service.suspend();
			System.out.println("temp sleep");
			TimeUnit.SECONDS.sleep(7);
			System.out.println("temp sleep passed, and resume");
			service.resume();
			TimeUnit.SECONDS.sleep(2);
			System.out.println("stop");
			service.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * http://java.sun.com/j2se/1.5.0/docs/guide/misc/threadPrimitiveDeprecation.html
	 * @author ASUS
	 *
	 */
	class PrintTaskService implements Runnable{
		private String info;
		private ReentrantLock lock=new ReentrantLock();
		private Condition condition=lock.newCondition();
		private volatile boolean suspend=false;
		private volatile boolean stop=false;
		public PrintTaskService(String info) {
			this.info=info;
		}
		@Override
		public void run() {
			lock.lock();
			try {
				while(!stop){
					while(suspend){
						condition.await();
					}
					TimeUnit.SECONDS.sleep(1);
					System.out.println(info);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		public void suspend() {
			suspend=true;
		}
		public void resume() {
			suspend=false;
			lock.lock();
			try {
				condition.signal();
			} finally {
				lock.unlock();
			}
		}
		public void stop() {
			stop=true;
		}
	}
}
;