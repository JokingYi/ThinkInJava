package com.my.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author ASUS
 * @��̬����
 * @��������������������"-ea"������ʹ��assert
 */
public class RequestInvocationHandler implements InvocationHandler
{
	private Object target;
	
	public RequestInvocationHandler(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println(proxy.getClass().getName());
		if (method.getName().equals("request"))
		{
			System.out.println("is request");
			return method.invoke(target, args);
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		ISubject subject=(ISubject) Proxy.newProxyInstance(RequestInvocationHandler.class.getClassLoader()
				, new Class[]{ISubject.class} 
				, new RequestInvocationHandler(new SubjectImpl()));
		System.out.println(subject.getClass().getName());//same with the proxy.name;
		subject.request();
	}

}
