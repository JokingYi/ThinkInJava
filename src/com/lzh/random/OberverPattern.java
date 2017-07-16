package com.lzh.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.ibatis.annotations.Delete;

interface Oberverable
{
	void addObserver(Observer observer);
	void deleteObserver(Observer observer);
	void notifyObserver();
}
interface Observer
{
	void update(String message);
}
class Subject implements Oberverable
{
	private List<Observer> observers;
	public Subject()
	{
		observers=new ArrayList<Observer>(); 
	}
	@Override
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}
	@Override
	public void deleteObserver(Observer observer)
	{
		int i=observers.indexOf(observer);
		if (i>0)
		{
			observers.remove(i);
		}
	}
	@Override
	public void notifyObserver()
	{
		for (Observer observer : observers)
		{
			observer.update("the message");
		}
	}
}
class ObserverImpl implements Observer
{
	private Subject subject;
	public ObserverImpl(Subject subject)
	{
		this.subject=subject;
		subject.addObserver(this);
	}
	@Override
	public void update(String message)
	{
		System.out.println("i got the message"+message);
	}
}
public class OberverPattern
{

}
