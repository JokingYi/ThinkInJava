package com.lzh.callback;

import java.util.concurrent.TimeUnit;

public class Quizzer implements CallBack, Runnable
{
	private Answer answer;
	public Quizzer(Answer answer)
	{
		this.answer = answer;
	}
	public void doSomethingElse()
	{
		try
		{
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void call(String question)
	{
		System.out.println("well done you answer is correct"+question);
	}
	@Override
	public void run()
	{
		answer.fixQuestion(this);
	}
	public static void main(String[] args)
	{
		Quizzer quizzer=new Quizzer(new Answer());
		new Thread(quizzer).start();
		quizzer.doSomethingElse();
	}
}
