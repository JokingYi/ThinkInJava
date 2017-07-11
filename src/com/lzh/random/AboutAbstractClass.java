package com.lzh.random;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

abstract class TestAboutAbstract
{
	
}

public abstract class AboutAbstractClass extends TestAboutAbstract
{
	public static void main(String[] args) throws FileNotFoundException
	{
		InputStream inputStream=new FileInputStream(new File(""));
	}
}
