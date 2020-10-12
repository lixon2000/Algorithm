package com.feelingtouch.Algorithm.dp;

/**
 * 
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @author admin
 *
 */
public class LongestSubSequence {

    public int lengthOfLIS(int[] nums) {
    	
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int len = nums.length;
    	int[] s = new int[len];		// 存放以i结尾的序列，最长的值
    	
    	// 初始状态
//    	for(int i=0;i<len;i++){
//    		s[i] = 1;
//    	}
    	
    	for(int i=0; i<len; i++){
    		int maxLen = 1;
    		for(int j=0; j<i; j++){
    			int a = 0;
    			if(nums[i] > nums[j]){
    				a = s[j] + 1;
    			} else{
    			}
    			maxLen = Math.max(maxLen, a);
    		}
    		s[i] = maxLen;
    	}
    	
    	int maxLen = 0;
    	for(int i=0; i<len; i++){
    		maxLen = Math.max(maxLen, s[i]);
    	}
    	return maxLen;
    }

    public static void main(String [] args){
//    	int [] a = new int[]{2,5,3,4};
    	int [] a = new int[]{4,10,4,3,8,9};
//    	int [] a = new int[]{6,5,5,6,3, 9, 11, 2, 4, 6};
    	LongestSubSequence s = new LongestSubSequence();
		System.out.println(s.lengthOfLIS(a));
    }
    
}
