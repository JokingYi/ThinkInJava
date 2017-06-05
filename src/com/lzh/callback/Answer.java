package com.lzh.callback;

public class Answer
{
	public void fixQuestion(CallBack callBack)
	{
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		callBack.call("the answer is ^&**&^");
	}
}
