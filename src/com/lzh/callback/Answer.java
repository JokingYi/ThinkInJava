package com.lzh.callback;

public class Answer
{
	public void fixQuestion(CallBack callBack)
	{
		//because this may takes some time to complete, so its needed to do it with 
		//callback, often with different thread
		try
		{
			Thread.sleep(10);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		callBack.call("the answer is ^&**&^");
	}
}
