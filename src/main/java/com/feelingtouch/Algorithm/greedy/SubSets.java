package com.feelingtouch.Algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 
 * @author admin
 *
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
    	return subsets(nums, nums.length);
    }

    // 数组nums前n个元素，与尾上的int做排列组合
    private List<List<Integer>> subsets(int[] nums, int n){
        if(n <= 0){
        	List<List<Integer>> retList = new ArrayList<>();
            List<Integer> tailSet = new ArrayList<>();
            retList.add(tailSet);
            return retList;
        }
        
        int tailNum = nums[n-1];
        List<List<Integer>> subList = subsets(nums, n-1);
        
        // 前面的数字加上尾数字
        List<List<Integer>> tmpList = new ArrayList<>();
        for(List<Integer> oneSet: subList){
        	List<Integer> newSet = new ArrayList<>();
        	newSet.addAll(oneSet);
        	newSet.add(tailNum);
        	tmpList.add(newSet);
        }
        
        subList.addAll(tmpList);
        
        return subList;
    }
    
    public static void main(String [] args){
    	
    	int [] a = new int[]{1};
    	SubSets s = new SubSets();
		s.subsets(a);
		
    }
}
