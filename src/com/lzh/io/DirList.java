package com.lzh.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList
{
	public static void main(String[] args)
	{
		File path=new File("d:/");
		String[] list=path.list(new DirFilter(".*\\.txt"));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String string : list)
		{
			File tempFile=new File(string);
//			System.out.println(tempFile.length());
//			System.out.println(tempFile.delete());//删不掉
			System.out.println(string);
		}
		File file=new File("d:/test.txt");
//		System.out.println(file.length());//必须是完整或者说是绝对路径
//		file.delete();//同理，也必须是完整路径
 	}
}
class DirFilter implements FilenameFilter
{
	private Pattern pattern;
	public DirFilter(String regex)
	{
		pattern=Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name)
	{
		return pattern.matcher(name).matches();
	}
	
}