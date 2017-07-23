package com.lzh.callback;

public class Quizzer implements CallBack, Runnable
{
	private Answer answer;
	public Quizzer(Answer answer)
	{
		this.answer = answer;
	}
	public void doSomethingElse()
	{
		for (int i = 0; i < 1000;i++)
		{
			System.out.println("我要看海贼王，解决好了的话就通知我");
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
