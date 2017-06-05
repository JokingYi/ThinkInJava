package com.lzh.callback;

public class Quizzer implements CallBack
{
	private Answer answer;
	
	public Quizzer(Answer answer)
	{
		this.answer = answer;
	}
	
	public void askQuestion()
	{
		answer.fixQuestion(this);
	}
	
	@Override
	public void call(String question)
	{
		System.out.println("well done you answer is correct"+question);
	}
	
	public static void main(String[] args)
	{
		Quizzer quizzer=new Quizzer(new Answer());
		quizzer.askQuestion();
	}
	
}
