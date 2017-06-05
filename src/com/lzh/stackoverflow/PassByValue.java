package com.lzh.stackoverflow;

class Dog
{
	private String name;

	public Dog(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

public class PassByValue
{
	public static void main(String[] args)
	{
		Dog dog=new Dog("max");
		foo1(dog);
//		foo2(dog);
		System.out.println("in main "+dog.getName());
	}
	
	//可以与final修饰方法参数的效果联系起来
	public static void foo1(Dog dog)
	{
		dog=new Dog("foo1");
		if (dog.getName().equals("foo1"))
		{
			System.out.println("inside foo1 true");
		}
	}
	public static void foo2(Dog dog)
	{
		dog.setName("foo2");
	}
}
