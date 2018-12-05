package com.my.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TheInterInvocationHandler implements InvocationHandler
{

	private Object target;
	
	public TheInterInvocationHandler(Object target)
	{
		this.target = target;
	}
	
	public static Object createProxy(Object object)
	{
		return Proxy.newProxyInstance(object.getClass().getClassLoader()
				, object.getClass().getInterfaces()
				, new TheInterInvocationHandler(object));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object result=null;
		System.out.println(method.getName()+"(...) called");
		result=method.invoke(target, args);
		System.out.println(method.getName()+"(...) returns");
		return result;
	}
	
	public static void main(String[] args)
	{
		/*
		 * normal implementation
		Object object=TheInterInvocationHandler.createProxy(new InterImpls());
		Inter1 inter1=(Inter1) object;
		Inter2 inter2=(Inter2) object;
		inter1.method1("");
		inter2.method2();
		*/
		
		Object object=TheInterInvocationHandler.createProxy(new DirectImpl());
		BaseInter baseInter=(BaseInter) object;
		baseInter.asBase();
		SuperInter superInter=(SuperInter) object;
		superInter.asSuper();
		//get super class
		Class<?> parent=object.getClass().getSuperclass();
		while(parent!=null){
			System.out.println(parent.getSimpleName());//print Proxy, Object in order
			parent=parent.getSuperclass();
		}
	}
}
