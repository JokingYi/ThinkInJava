package com.lzh.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class CasNumberRange {
	private static class InitPair{
		final int lower;
		final int upper;
		public InitPair(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}
	}
	private final AtomicReference<InitPair> values=
			new AtomicReference<CasNumberRange.InitPair>(new InitPair(0, 0));
	
	public int getLower() {
		return values.get().lower;
	}
	public int getUpper() {
		return values.get().upper;
	}
	public void setLower(int i) {
		while(true){
			InitPair initPair=values.get();
			if(initPair.upper<i)
				throw new IllegalArgumentException("lower greater then upper");
			InitPair newPair=new InitPair(i, initPair.upper);
			if(values.compareAndSet(initPair, newPair))
				return;
		}
	}
	public void setUpper(int i) {
		while(true){
			InitPair old=values.get();
			if(old.lower>i)
				throw new IllegalArgumentException("upper lesser then lower");
			InitPair newPair=new InitPair(old.lower, i);
			if(values.compareAndSet(old, newPair))
				return;
		}
	}
}
