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
//		System.out.println("constructor");
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
	protected Person clone() throws CloneNotSupportedException
	{
		System.out.println(super.getClass().getName());//��������ʱ�����Ϣ���˴���Person
		System.out.println(this.getClass().getSuperclass().getName());
		return (Person) super.clone();
	}
	@Override
	public String toString()
	{
		return name+" "+id;
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
 * test if its possible to clone with final fields
 * @author ASUS
 *
 */
class CloneWithFinalField implements Cloneable
{
	private final int id;

	public CloneWithFinalField(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return id+"";
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
		CloneWithFinalField[] fields=new CloneWithFinalField[10];
		for (int i = 0; i < fields.length; i++)
		{
			fields[i]=new CloneWithFinalField(i);
		}
		CloneWithFinalField[] fields1=fields.clone();
		for (CloneWithFinalField cloneWithFinalField : fields1)
		{
			System.out.println(cloneWithFinalField);
		}
		
		/*
		//array copy
		Person[] persons=new Person[10];
		for (int i = 0; i < persons.length; i++)
		{
			persons[i]=new Person("#name"+i, i);
		}
		Person[] persons2=persons.clone();
		
		persons[1].setName("changed");
		
		//turns out to be shallow copy
		for (Person person : persons2)
		{
			System.out.println(person);
		}
		*/
		
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
			//û�е��ù��캯��
			Person person2=person.clone();
			System.out.println(person==person2);//�����true������clone�����
			System.out.println(person.getName()==person2.getName());//�����true���������ֶ�clone��ǳ����
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		*/
		/*
		//fail to cloned if not implement cloneable, in addition, the array implements the clonable by default
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
