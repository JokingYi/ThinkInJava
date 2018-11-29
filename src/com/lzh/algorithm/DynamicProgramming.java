package com.lzh.algorithm;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
	
public class DynamicProgramming
{
	//triangle max path
	static final int MAX_NUM=4, HEIGHT=4;
	static int[][] triangle=new int[HEIGHT][HEIGHT];
	static int[][][] cache=new int[HEIGHT][HEIGHT][MAX_NUM*HEIGHT+1];
	static int[][] cache2=new int[HEIGHT][HEIGHT];
	static int[] tab=new int[50];
	//LIS
	static List<Integer> numList= Arrays.asList(7,8,1,2,5,4,6,9);
	
	@BeforeClass
	public static void init()
	{
		Arrays.fill(tab, -1);
		//fill in triangle
		for(int i=0; i<triangle.length; i++){
			for(int j=0; j<triangle[0].length; j++){
				if(i>=j){
					triangle[i][j]=i+j+1;
				}
			}
		}
	}
	@Test
	public void testInterview() throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("you input: "+reader.readLine());
	}
//	@Test
	public void testRecitePI()
	{
		String numbers="12345";
		System.out.println(memorize(numbers, 0));
	}
	public int memorize(String number, int begin)
	{
		if(begin==number.length()-1)
			return 0;
		if(tab[begin]!=-1)
			return tab[begin];
		for(int l=3; l<=5; l++){
			if(begin+l<number.length()){
				tab[begin]=Math.max(tab[begin], memorize(number, begin+l)
						+classify(number, begin, begin+l));
			}
		}
		return tab[begin];
	}
	public int classify(String numbers, int start, int end)
	{
		if(end-start>5)
			throw new IllegalArgumentException("interval should not be greater than 5");
		int[] buffer=new int[5];
		int count=0;
		int preDiff=numbers.charAt(start)-numbers.charAt(start+1);
		boolean same=true, asame=true;
		for(int i=start; i<end-1; i++){
			int currDiff=numbers.charAt(i)-numbers.charAt(i+1);
			if(currDiff!=preDiff){
				same=false;
			}
			if(Math.abs(currDiff)!=Math.abs(preDiff)){
				asame=false;
			}
			buffer[count++]=currDiff;
			preDiff=currDiff;
		}
		if(same)
			asame=false;
		boolean type1=true, type2=true, type3=true, type4=true;
		for (int i=0; i<count; i++)
		{
			int diff=buffer[i];
			if(!same){
				type1=false;
				type2=false;
				type4=false;
			}
			if(!asame){
				type3=false;
			}
			if(same && diff!=0){
				type1=false;
			}
			if(same && diff!=1 && diff!=-1){
				type2=false;
			}
		}
		return type1?1:
				 type2?2:
					type3?4:
						type4?5:10;
	}
	int getComplex(boolean type1, boolean type2, boolean type3, boolean type4)
	{
		if(type1)
			return 1;
		else if(type2)
			return 2;
		else if(type3)
			return 4;
		else if(type4)
			return 5;
		else 
			return 10;
	}
//	@Test
	public void testGetLIS2()
	{
		System.out.println(getLIS2(0));
	}
//	@Test
	public void testGetLIS()
	{
		System.out.println(getLIS(Arrays.asList(7,8,1,2,5,4,6,9)));
	}
//	@Test
	public void testTriangleMaxPath2()
	{
		System.out.println(triangleMaxPath(0, 0));
		for (int[] is : cache2)
		{
			for (int i : is)
			{
				System.out.print(i+"~");
			}
			System.out.println();
		}
	}
//	@Test
	public void testTriangleMaxPath()
	{
		System.out.println(triangleMaxPath(0, 0, 0));
		for (int[][] is : cache)
		{
			for (int[] is2 : is)
			{
				for (int i : is2)
				{
					System.out.print(i+"~");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
//	@Test
	public void testWildPatternMatchRefined()
	{
		String pattern="*lc", target="lalc";
		assertTrue(wildPatternMatchRefined(pattern, target));
	}
//	@Test
	public void testWildPatternMatch()
	{
		String pattern="*lc", target="lalc";
		assertTrue(wildPatternMatch(pattern.toCharArray(), target.toCharArray()));
	}
//	@Test
	public void testBino()
	{
		System.out.println(bino(3, 2));
	}
	int getLIS2(int index){
		int length=0;
		for (int i = 0; i < numList.size(); i++)
		{
			length=Math.max(length, innerGetLIS2(i));
		}
		return length;
	}
	int innerGetLIS2(int index){
		if(index > numList.size()-1) return 0;
		int ret=1;
		for (int i = index+1; i < numList.size(); i++)
		{
			int subRet=0;
			if(numList.get(i) > numList.get(index)){
				subRet=innerGetLIS2(i);
			}
			ret=Math.max(ret, subRet+1);
		}
		return ret;
	}
	int getLIS(List<Integer> nums){
		if(nums.isEmpty()) return 0;
		int ret=0;
		for (int i=0; i<nums.size(); i++)
		{
			List<Integer> subNums=new ArrayList<>(nums.size());
			for(int j=i+1; j<nums.size(); j++)
				if(nums.get(i)<nums.get(j)) subNums.add(nums.get(j));
			ret=Math.max(ret, getLIS(subNums)+1);
		}
		return ret;
	}
	
	int triangleMaxPath(int y, int x){
		if(y==HEIGHT-1) return triangle[y][x];
		int ret=cache2[y][x];
		if(ret!=0) return ret;
		return ret=triangle[y][x]+Math.max(triangleMaxPath(y+1, x), triangleMaxPath(y+1, x+1));
	}
	
	int triangleMaxPath(int y, int x, int sum){
		if(y==HEIGHT-1) return sum+triangle[y][x];
		int ret=cache[y][x][sum];
		if(ret!=0) return ret;
		sum+=triangle[y][x];
		return cache[y][x][sum]=Math.max(triangleMaxPath(y+1, x, sum), 
				triangleMaxPath(y+1, x+1, sum));
	}
	
	boolean wildPatternMatchRefined(String pattern, String target){
		int pos=0;
		while(pos<pattern.length() && pos<target.length() 
				&& (pattern.charAt(pos) == '?' || pattern.charAt(pos)==target.charAt(pos)))
			++pos;
		if(pos==pattern.length()) return pos==target.length();
		if(pattern.charAt(pos)=='*'){
			for(int skip=0; skip+pos<pattern.length(); skip++){
				if(wildPatternMatchRefined(pattern.substring(pos+1), target.substring(skip+pos)))
					return true;
			}
		}
		return false;
	}
	/**
	 * fail-> won't work for {pattern: "*lc", target: "lalc"}
	 * @param pattern
	 * @param target
	 * @return
	 */
	boolean wildPatternMatch(char[] pattern, char[] target){
		final char WILD='*', QUESTIONMARK='?';
		boolean matched=true;
		int j=0;
		for(int i=0; i<pattern.length && j<target.length; i++){
			char currPattern=pattern[i], curTarget=target[j];
			if(currPattern==WILD){
				int tempI=i+1;
				if(tempI==pattern.length) return matched;
				char nextPattern=pattern[tempI];
				while(true){
					if(nextPattern==WILD || nextPattern==QUESTIONMARK) {
						if(++tempI==pattern.length) return matched;
						nextPattern=pattern[tempI];
					}else{
						break;
					}
				}
				while(j<target.length){
					if(curTarget==nextPattern){
						matched=true;
						i=tempI;
						break;
					}
					matched=false;
					if(++j==target.length) return matched;
					curTarget=target[j];
				}
			}else if(currPattern==QUESTIONMARK){
				++j;
			}else if(currPattern==curTarget){
				++j;
				matched=true;
			}else {
				matched=false;
				return matched;
			}
		}
		if(j<target.length) return false;
		return matched;
	}
	int bino(int n, int r){
		if(r==0 || n==r) return 1;
		return bino(n-1, r-1)+bino(n-1, r);
	}
}
