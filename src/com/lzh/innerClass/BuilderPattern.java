package com.lzh.innerClass;

import java.util.Date;

public class BuilderPattern
{
	private int size;
	private Date expireTime;
	
	private int calories;
	private int sodium;
	
	private BuilderPattern(Builder builder)
	{
		size=builder.size;
		expireTime=builder.expireTime;
		calories=builder.calories;
		sodium=builder.sodium;
	}
	
	public static class Builder
	{
		private int size;
		private Date expireTime;
		
		private int calories=0;
		private int sodium=0;
		
		public Builder(int size, Date expireTime)
		{
			this.size = size;
			this.expireTime = expireTime;
		}
		
		public Builder calories(int calories)
		{
			this.calories=calories;
			return this;
		}
		
		public Builder sodium(int sodium)
		{
			this.sodium=sodium;
			return this;
		}
		
		public BuilderPattern build()
		{
			return new BuilderPattern(this);
		}
	}
	
	public static void main(String[] args)
	{
		BuilderPattern pattern=new Builder(550, new Date()).calories(100).build();
	}
}
