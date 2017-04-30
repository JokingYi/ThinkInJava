package com.my.dynamicProxy;


/**
 * @author jok
 * 	@¾²Ì¬´úÀí
 */
public class SubjectProxy implements ISubject
{
	private ISubject target;
	
	public SubjectProxy(ISubject target)
	{
		this.target = target;
	}

	@Override
	public void request()
	{
		//do some pre process if necessary
		target.request();
		//do some pre process if necessary
		System.out.println("in proxy");
	}

	public ISubject getTarget()
	{
		return target;
	}

	public void setTarget(ISubject target)
	{
		this.target = target;
	}
}
