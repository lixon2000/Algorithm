package com.feelingtouch.Algorithm.sort;

/**
 * 242. 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @author admin
 *
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()){
    		return false;
    	}
    	
    	int[] cnt = new int[26];
    	
    	for(int index = 0; index < s.length(); index++){
    		cnt[s.charAt(index) - 'a'] ++;
    		cnt[t.charAt(index) - 'a'] --;
    	}
    	for(int c: cnt){
    		if(c != 0){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	String s = "abcd";
    	String t = "abce";
    	ValidAnagram v = new ValidAnagram();
    	System.out.print(v.isAnagram(s, t));
    }
}
