package com.lzh.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * bowling score rule
 * @author ASUS
 *
 */
public class BowlingInterview {
	static final char STRIKE='X';
	static final char SPIKE='/';
	static final char NONE='-';
	
	public static void main(String[] args) {
//		System.out.println(target("XXXXXXXXXXXX"));
//		System.out.println(target("12345432123454321234"));
		System.out.println(target("X129/X111111111111"));
	}
	public static int target(String input) {
		int total=0;
		boolean roundEnd=false;
		boolean preSpecial=false;
		int preScore=0;
		int curScore=0;
		int roundCount=0;
		List<RoundStatus> roundStatuses=new LinkedList<>();
		
		for (int i = 0; i < input.length(); i++) {
			char curChar=input.charAt(i);
			RoundStatus status=null;
			
			if(STRIKE==curChar){
				roundEnd=true;
				curScore=10;
				preSpecial=true;
				status=new RoundStatus(true, STRIKE, 0, 0, 2);
				if(roundCount<10)
					roundStatuses.add(status);
			}else if(SPIKE==curChar){
				curScore=10;
				roundEnd=true;
				preSpecial=true;
				status=new RoundStatus(true, SPIKE, preScore, 10-preScore, 1);
				if(roundCount<10)
					roundStatuses.add(status);
			}else{
				int temp=0;
				if(curChar==NONE) temp=0;
				else temp=Integer.valueOf(""+curChar);
				
				if(!preSpecial && i!=0 && !roundEnd){
					roundEnd=true;
					curScore=preScore+temp;
					status=new RoundStatus(false, ' ', preScore, temp, 0);
				}else{
					preScore=temp;
					preSpecial=false;
					roundEnd=false;
				}
			}

			if(roundEnd){
				roundCount++;
				if(roundCount<=10)
					total+=curScore;
				Iterator<RoundStatus> iterator=roundStatuses.iterator();
				while(iterator.hasNext() ){
					RoundStatus cur=iterator.next();
					if(cur==status) break;
					else{
						if(cur.countDown==0) iterator.remove();
						else{
							if(status.specialChar!=STRIKE){
								if(cur.countDown==1){
									cur.countDown--;
									total=total+status.first;
								}else {
									cur.countDown=0;
									total=total+status.first+status.second;
								}
							}else{
								cur.countDown--;
								total+=curScore;
							}
						}
					}
				}
			}
		}
		return total;
	}
}
class RoundStatus{
	boolean isSpecial;
	char specialChar;
	int first;
	int second;
	int countDown;
	public RoundStatus(boolean isSpecial, char specialChar, int first, int second, int countDown) {
		this.isSpecial = isSpecial;
		this.specialChar = specialChar;
		this.first = first;
		this.second = second;
		this.countDown = countDown;
	}
	@Override
	public String toString() {
		return isSpecial+", "+specialChar+", "+first+", "+second+", "+countDown;
	}
}