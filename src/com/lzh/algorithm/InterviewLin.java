package com.lzh.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InterviewLin {
	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			Integer budget= Integer.valueOf(reader.readLine());
			String[] priceStrings=reader.readLine().split(" ");
			int[] prices=new int[priceStrings.length];
			
			for (int i=0; i<priceStrings.length; i++) {
				prices[i]=Integer.valueOf(priceStrings[i]);
			}
			Arrays.sort(prices);
			int sum=0;
			for (Integer price : prices) {
				if(sum+price>budget)
					break;
				sum+=price;
			}
			System.out.println(sum);
		}
	}
}
