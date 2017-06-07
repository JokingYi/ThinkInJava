package com.lzh.modifier;

import java.util.jar.Attributes.Name;

public class CacheImmutable
{
	private final String string;
	private static CacheImmutable[] caches=new CacheImmutable[10];
	private static int pos=0;
	
	public CacheImmutable(String string)
	{
		this.string = string;
	}
	
	public static CacheImmutable valueOf(String string)
	{
		for(int i=0;i<pos; i++)
		{
			if (caches[i]!=null && 
					caches[i].getString().equals(string))
			{
				return caches[i];
			}
		}
		if (pos==10)
		{
			caches[0]=new CacheImmutable(string);
			pos=1;
			return caches[0];
		}else
		{
			caches[pos++]=new CacheImmutable(string);
			return caches[pos-1];
		}
	}
	
	public String getString()
	{
		return string;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof CacheImmutable)
		{
			CacheImmutable cacheImmutable=(CacheImmutable) obj;
			//可以直接拿到string，即使是private
			if (cacheImmutable.getString().equals(this.string))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return string.hashCode();
	}
	
	public static void main(String[] args)
	{
		CacheImmutable cacheImmutable1=CacheImmutable.valueOf("1");
		CacheImmutable cacheImmutable2=CacheImmutable.valueOf("1");
		System.out.println(cacheImmutable1==cacheImmutable2);
	}
}
