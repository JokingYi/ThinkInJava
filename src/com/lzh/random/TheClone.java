package com.lzh.random;

class Person implements Cloneable
{
	private String name;
	private int id;
	public Person(String name, int id)
	{
		super();
		this.name = name;
		this.id = id;
	}
	public Person()
	{
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

/**
 * something about clone
 * @author ASUS
 *
 */
public class TheClone
{
	public static void main(String[] args)
	{
		
		Person person=new Person("long", 0);
		try
		{
			Person person2=(Person) person.clone();
			System.out.println(person.getName()==person2.getName());
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		/*
		//fail to cloned if not implement cloneable
		Book book=new Book("a", 0f);
		try
		{
			Book book2=(Book) book.clone();
			System.out.println(book.getName()==book2.getName());
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		*/
		/*
		String a=new String("a");
		String b=new String("a");
		System.out.println(a==b);
		*/
	}
}
