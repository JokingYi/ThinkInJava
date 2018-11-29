package com.lzh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interview {
	static final String group1="ABCDEFGHI";
	static final String group2="JKLMNOPQR";
	static final String group3="STUVWXYZ ";
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] date=reader.readLine().split(" ");
			String message=reader.readLine();
			
			target(date, message);
		}
	}
	public static void target(String[] date, String message) {
		int month=Integer.valueOf(date[0])-1;
		int day=Integer.valueOf(date[1])-1;
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			char ch=message.charAt(i);
			int left=0, right=0, index, temp;
			if((index=group1.indexOf(ch))!=-1){
				left=1+(3-month%3)%3;
			}else if((index=group2.indexOf(ch))!=-1){
				temp=2-month%3;
				left=temp>0?temp:temp+3;
			}else if((index=group3.indexOf(ch))!=-1){
				left=3-month%3;
			}else {
				throw new IllegalArgumentException("unknow input!");
			}
			temp=1+index-day%9;
			right=temp>0?temp:temp+9;
			stringBuilder.append(left+"").append(right+" ");
		}
		System.out.println(stringBuilder.toString().substring(0, stringBuilder.length()-1));
	}
}
