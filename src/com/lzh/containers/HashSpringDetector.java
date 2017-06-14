package com.lzh.containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

class GroundHog
{
	protected int id;

	public GroundHog(int id)
	{
		this.id = id;
		System.out.println("test if executed in reflection");//µ÷ÓÃÁË
	}
	@Override
	public String toString()
	{
		return "ground#"+id;
	}
}

class Prediction
{
	private boolean shadow = Math.random()>0.5;
	@Override
	public String toString()
	{
		if (shadow)
		{
			return "0.5 bigger";
		}else
		{
			return "0.5 lesser";
		}
	}
}

//solution with hashcode() and equals()
class HashGroundHog extends GroundHog
{
	public HashGroundHog(int id)
	{
		super(id);
	}
	@Override
	public int hashCode()
	{
		return id;
	}
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof HashGroundHog && 
				(id == ((HashGroundHog) obj).id);
	}
}


public class HashSpringDetector
{
	public static <T extends GroundHog> void detectSpring(Class<T> type) throws Exception
	{
		Constructor<T> gHog=type.getConstructor(int.class);
		Map<GroundHog, Prediction> map=new HashMap<>();
		for (int i = 0; i < 10; i++)
		{
			map.put(gHog.newInstance(i), new Prediction());
		}
		System.out.println("map: "+map);
		
		GroundHog groundHog=gHog.newInstance(3);
		System.out.println("look up prediction for "+groundHog);
		
		if (map.containsKey(groundHog))
		{
			System.out.println(map.get(groundHog));
		}else
		{
			System.out.println("nope!");
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			detectSpring(HashGroundHog.class);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
