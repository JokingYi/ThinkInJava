package com.lzh.test;

import java.io.File;

public class JavaToExe
{

	public static void main(String[] args)
	{
		File  file = new File("d:/test2.txt");
		System.out.println(file.delete());
	}

}
