package com.lzh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	public static void main(String[] args) throws InterruptedException {
		ExecutorServiceDemo demo=new ExecutorServiceDemo();
		demo.shutdownWithThread();
	}
	public void shutdownWithThread() throws InterruptedException {
		ExecutorService service=Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {
			@Override
			public void run() {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							System.out.println("inner thread start");
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}finally {
							System.out.println("inner thread end");
						}
					}
				}).start();
			}
		});
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MICROSECONDS);
		System.out.println("outer end");
	}
	public void shutDownDemo() {
		ExecutorService service=Executors.newFixedThreadPool(1);
		service.submit(new SimpleTask(5));
		service.submit(new SimpleTask(6));
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Runnable> tasks= service.shutdownNow();//return task that never started
		System.out.println(tasks.size());
		System.out.println(tasks);
	}
	class SimpleTask implements Runnable{
		int seconds;
		public SimpleTask(int seconds) {
			this.seconds=seconds;
		}
		@Override
		public void run() {
			try {
				System.out.println("task"+seconds+" started");
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				System.out.println("task"+seconds+" ended");
			}
		}
	}
	public void basic() {
		ExecutorService service=Executors.newFixedThreadPool(2);
		try {
			List<Future<String>> result=service.invokeAll(getTasks());
			for (Future<String> future : result) {
				System.out.println(future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}
	public void scheduledBasicDemo() {
		ScheduledExecutorService service=new ScheduledThreadPoolExecutor(1);
		service.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("print task");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 2, TimeUnit.SECONDS);
		service.shutdown();
	}
	
	public List<Callable<String>> getTasks() {
		List<Callable<String>> tasks=new ArrayList<>();
		tasks.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task1";
			}
		});
		tasks.add(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "task2";
			}
		});
		return tasks;
	}
}
