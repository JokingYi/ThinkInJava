package com.lzh.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;
	
public class DynamicProgramming
{
	@Test
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
