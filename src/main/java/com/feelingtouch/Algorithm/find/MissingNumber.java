package com.feelingtouch.Algorithm.find;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 也可以通过数组中每个数字异或再异或n个数字来求解
 * 
 * @author admin
 *
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
    	int n = nums.length;
    	int total = n*(n+1)/2;
    	for(int num: nums){
    		total -= num;
    	}
    	return total;
    }
    
    public static void main(String [] args){
    	
    	int [] a = new int[]{0, 2, 1, 5, 4};
    	MissingNumber s = new MissingNumber();
		s.missingNumber(a);
		
    }
}
