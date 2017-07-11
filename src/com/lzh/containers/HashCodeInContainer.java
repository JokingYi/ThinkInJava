package com.lzh.containers;

import java.util.HashMap;
import java.util.Map;

public class HashCodeInContainer
{
	private static class Item
	{
		private int index;
		public Item(int index)
		{
			super();
			this.index = index;
		}
		@Override
		public String toString()
		{
			return ""+index;
		}
		@Override
		public int hashCode()
		{
			return index;
		}
		@Override
		public boolean equals(Object obj)
		{
			return obj instanceof Item && (this.index==((Item)obj).index);
		}
	}
	
	public static void main(String[] args)
	{
		Map<Item, String> testHash=new HashMap<>();
		testHash.put(new Item(1), "test");
		testHash.put(null, "the null");	
		System.out.println(testHash.containsKey(new Item(1)));
		
	}
}
