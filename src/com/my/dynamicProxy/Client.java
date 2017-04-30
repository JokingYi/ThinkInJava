package com.my.dynamicProxy;

public class Client
{
	private ISubject subject;
	public Client(ISubject subject)
	{
		this.subject = subject;
	}

	public void doRequest()
	{
		subject.request();
	}
	
	public static void main(String[] args)
	{
		Client client=new Client(new SubjectProxy(new SubjectImpl()));
		client.doRequest();
	}
}
