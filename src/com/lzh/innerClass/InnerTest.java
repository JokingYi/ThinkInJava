package com.lzh.innerClass;

class Outer{
	public Outer(){
		System.out.println("outer");
	}
}
class WithInner extends Outer{
	int i;
	public WithInner(int i)	{
		this.i=i;
		System.out.println("with inner");
	}
	@Override
	public String toString(){
		return i+"";
	}
	class Inner{
		@Override
		public String toString(){
			return "inner "+i;
		}
	}
}
public class InnerTest extends WithInner.Inner 
{
	public InnerTest(){
		new WithInner(1).super();
	}
	public static void main(String[] args){
//		System.out.println(new InnerTest());
		WithInner withInner= new WithInner(2);
	}
}
