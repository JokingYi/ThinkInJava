package com.lzh.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Mouse
{
	private String name;
	private String shape;
	private boolean isSilence;

	public Mouse()
	{
		name="";
	}
	public Mouse(String name)
	{
		this.name = name;
	}

	public String getShape()
	{
		return shape;
	}
	public void setShape(String shape)
	{
		this.shape = shape;
	}
	public boolean isSilence()
	{
		return isSilence;
	}
	public void setSilence(boolean isSilence)
	{
		this.isSilence = isSilence;
	}
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	//默认是通过==来判断
	@Override
	public boolean equals(Object obj)
	{
		Objects.requireNonNull(obj);
		if (obj==this)
			return true;
		Mouse mouse=(Mouse) obj;
		if (this.name.equals(mouse.getName()))
			return true;
		return false;
	}
}
public class EqualInContainer
{
	public static void main(String[] args)
	{
		List<Mouse> mouses=new ArrayList<>();
		mouses.add(new Mouse());
		mouses.add(new Mouse("a"));
		mouses.add(new Mouse("a"));
		mouses.add(new Mouse("b"));
		//method based on method equal();
		//first occurence;
//		System.out.println(mouses.indexOf(new Mouse("a")));
		mouses.remove(new Mouse("a"));
		System.out.println(mouses.size());
	}
}
