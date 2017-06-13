package com.lzh.random;

/**
 * simple clone
 * @author ASUS
 *
 */
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
		System.out.println(super.getClass().getName());//��������ʱ�����Ϣ���˴���Person
		System.out.println(this.getClass().getSuperclass().getName());
		return super.clone();
	}
}

/**
 * double clone
 */

class Computer implements Cloneable
{
	private Mouse mouse;

	public Computer(Mouse mouse)
	{
		this.mouse = mouse;
	}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Computer computer=(Computer) super.clone();
		computer.mouse=(Mouse) this.mouse.clone();
		
		return computer;
	}
	public Mouse getMouse()
	{
		return mouse;
	}
	
}

class Mouse implements Cloneable
{
	@Override
	public Object clone() throws CloneNotSupportedException
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
		/*
		Computer computer=new Computer(new Mouse());
		try
		{
			Computer computer2= (Computer) computer.clone();
			System.out.println(computer.getMouse()==computer2.getMouse());
		} catch (CloneNotSupportedException e)
		{
			
			e.printStackTrace();
		}
		*/
		/*
		String a=new String("a");
//		String b=a;//1
		String b=new String("a");//2
		
//		bString=new String("b");
//		System.out.println(a);
		
		System.out.println(b==a);//1��2��Ӧ����������:true��false
		*/
		/*
		//
		Person person=new Person("long", 0);
		try
		{
			Person person2=(Person) person.clone();
			System.out.println(person==person2);//�����true������clone�����
			System.out.println(person.getName()==person2.getName());//�����true���������ֶ�clone��ǳ����
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		*/
		
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
