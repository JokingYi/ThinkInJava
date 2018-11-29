package com.lzh.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

interface Computable<A, V>{
	V compute(A arg) throws InterruptedException;
}

public class AdvanceMemrizor<A, V> implements Computable<A, V>{
	private final ConcurrentHashMap<A, Future<V>> cache=new ConcurrentHashMap<>();
	private final Computable<A, V> c;
	
	public AdvanceMemrizor(Computable<A, V> c) {
		this.c = c;
	}
	public static void main(String[] args) throws InterruptedException {
		Computable<String, String> task=new Computable<String, String>() {
			@Override
			public String compute(String arg) throws InterruptedException {
				System.out.println("the arg is "+arg+", start compute...");
				TimeUnit.SECONDS.sleep(2);
				return "2s";
			}
		}; 
		AdvanceMemrizor<String, String> memrizor=new AdvanceMemrizor<>(task);
		String result= memrizor.compute("test");
		System.out.println(result);
	}
	@Override
	public V compute(A arg) throws InterruptedException {
		while(true){
			Future<V> future=cache.get(arg);
			if(future==null){
				Callable<V> eval=new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				FutureTask<V> futureTask=new FutureTask<>(eval);
				future=cache.putIfAbsent(arg, futureTask);
				if(future==null){
					future=futureTask;
					futureTask.run();
				}
			}
			try {
				return future.get();
			} catch (CancellationException e) {
				cache.remove(arg, future);
			} catch (ExecutionException e) {
				throw new InterruptedException(e.getMessage());
			}
		}
	}
}
