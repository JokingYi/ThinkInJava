package com.lzh.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class Directory
{
	public static File[] local(File dir, String regex)
	{
		return dir.listFiles(new FilenameFilter()
		{
			
			@Override
			public boolean accept(File dir, String name)
			{
				//д�ɶ��б��ڲ���
				return Pattern.compile(regex)
						.matcher(name)
						.matches();
			}
		});
	}
}
