package com.my.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ASUS
 * @动态代理
 * @请在虚拟机参数里面添加"-ea"参数以使用assert
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
			System.out.println("pre processing");
			Object result=method.invoke(target, args);
			System.out.println("post processing");
			return result;
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		//动态代理只针对实现相应的interface的类
		ISubject subject=(ISubject) Proxy.newProxyInstance(RequestInvocationHandler.class.getClassLoader()
				, new Class[]{ISubject.class} 
				, new RequestInvocationHandler(new SubjectImpl()));
		Class<?> subjectClass=Proxy.getProxyClass(RequestInvocationHandler.class.getClassLoader()
				, new Class[]{ISubject.class} );
		System.out.println(subjectClass.getName());//same with the next line
		System.out.println(subject.getClass().getName());//same with the proxy.name;
		subject.request();
	}

}
