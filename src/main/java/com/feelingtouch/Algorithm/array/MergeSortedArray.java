package com.feelingtouch.Algorithm.array;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 思路：双指针从后向前填充
 * @author admin
 *
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	
    	// 指向最后
    	int p1 = m-1;
    	int p2 = n-1;
    	
    	int p = m+n-1;
    	
    	while(p1 >= 0 && p2 >= 0){
    		int max = 0;		// 大的数
    		if(nums1[p1] > nums2[p2]){
    			max = nums1[p1];
    			p1--;
    		} else{
    			max = nums2[p2];
    			p2--;
    		}
    		nums1[p] = max;
    		p--;
    	}
    	
    	// nums2剩余部分
    	if(p2 >= 0){
    		System.arraycopy(nums2, 0, nums1, 0, p2+1);
    	}
    }
    
    public static void main(String [] args){
    	
    	int [] a = new int[]{2, 6, 9, 0, 0, 0};
    	int [] b = new int[]{1, 3, 4};
    	MergeSortedArray s = new MergeSortedArray();
		s.merge(a, 3, b, 3);
		
    }
}
