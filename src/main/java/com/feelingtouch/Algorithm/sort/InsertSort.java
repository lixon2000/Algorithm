package com.feelingtouch.Algorithm.sort;

public class InsertSort {
	
	
	public static class MinNumberSolution {
	    public String minNumber(int[] nums) {

	    	String[] numStrs = new String[nums.length];
	    	for(int i=0; i<nums.length; i++){
	    		numStrs[i] = String.valueOf(nums[i]);
	    	}
	    	
	    	sort(numStrs);
	    	
	    	StringBuilder sb = new StringBuilder(); 
	    	for(String s: numStrs){
	    		sb.append(s);
	    	}
	    	return sb.toString();
	    }
	    
	    private void sort(String[] numStrs){
	    	// 插入排序 
	    	int arrayLen = numStrs.length;
	    	if(arrayLen <= 1){
	    		return;
	    	}
	    	
	    	for(int i=1; i<arrayLen; i++){
	    		
	    		// [0,i-1]是排好序的区间
	    		String value = numStrs[i];
	    		int j=i-1;
	    		for(; j>=0; j--){
	    			if(compare(value, numStrs[j]) < 0){
	    				numStrs[j+1] = numStrs[j];
	    			} else{
	    				break;
	    			}
	    		}
	    		numStrs[j+1] = value;
	    	}
	    	
	    }
	    
	    // 1:a>b; -1:a<b
	    private int compare(String a, String b){
	    	return (a+b).compareTo(b+a);
	    }
	}
	
	
	public static void main(String[] args){
		
		MinNumberSolution s = new MinNumberSolution();
		int[] nums = new int[]{21, 22, 23, 20, 999999999};
		System.out.println(s.minNumber(nums));
		
	}

}
