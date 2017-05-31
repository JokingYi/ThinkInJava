package com.lzh.algorithm;

public class CutString
{
	public static void doWork(String string, int bytesNum)
	{
		System.out.print("截取到的字符串：");
		if (bytesNum==0)
			System.out.print("nope");
		String[] strings=string.split("");
		int length=0;
		for (int i = 0; i < strings.length; i++)
		{
			length+=strings[i].getBytes().length;
			if (length> bytesNum)
				break;
			else
				System.out.print(strings[i]);
		}
  		
	}
	
	public static void main(String[] args)
	{
		String test="wtf 呵呵";
		CutString.doWork(test, 0);
//		System.out.println(Character.isLetter('我'));//true
//		for(int i=0; i< 256; i++)
//		{
//			System.out.println("number "+i+" is letter? "+Character.isLetter(i));
//		}
		
		/*
		byte[] bytes=mix.getBytes();
		Stack<Integer> index=new Stack<>();
		for (int i = 0; i < bytes.length; i++)
		{
			if (bytes[i] > -1 && bytes[i] < 256)
			{
				System.out.print((char) bytes[i]);
			}else 
			{
				if (index.empty())
				{
					index.push(i);
					System.out.print(mix.charAt(i));
				}else
				{
					if (i != index.peek()+1)
					{
						index.push(i);
						System.out.print(mix.charAt(i));
					}
				}
			}
		}*/
	}
}
