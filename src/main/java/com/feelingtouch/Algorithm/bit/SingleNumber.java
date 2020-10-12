package com.feelingtouch.Algorithm.bit;


/**
 * 136. 只出现一次的数字
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 思路：位运算，异或满足交换律和结合律
 * 
 * @author admin
 *
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
    	int ret = 0;
    	for(int num: nums){
    		ret = ret ^ num;
    	}
    	return ret;
    }
    
	public static void main(String[] args) {
		int [] intervals = new int[]{18, 2, 5, 4, 5, 7, 18, 4, 7};
		SingleNumber s = new SingleNumber();
		int a = s.singleNumber(intervals);
		System.out.println(a);
	}
    
}
