package com.feelingtouch.Algorithm.find;


//说明：
//不能更改原数组（假设数组是只读的）。
//只能使用额外的 O(1) 的空间。
//时间复杂度小于 O(n2) 。
//数组中只有一个重复的数字，但它可能不止重复出现一次。

/**
 * 寻找重复数
 * 
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 
 * @author admin
 *
 */
public class FindDuplicateNumber {
	
	/**
	 * 抽屉原理计数
	 * 
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
    	
    	int l = 1;
    	int r = nums.length - 1;
    	// 遍历所有可能的整数
    	while(l <= r){
    		int mid = l + (r - l)/2;
    		
    		// 查找比mid小的数的个数
    		int cnt = 0;
    		for(int i: nums){
    			if(i <= mid){
    				cnt ++;
    			}
    		}
    		
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
    		// cnt大于mid，重复的数在右边
    		if(cnt > mid){
    			r = mid - 1;
    		} else{
    			l = mid + 1;
    		}
    	}
    	
    	return l;
    }
    
    /**
     * 快慢指针查找环
     * 
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
    	
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        //寻找相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //slow 从起点出发, fast 从相遇点出发, 一次走一步
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    public static void main(String[] args){
    	int[] a = new int[]{2, 5, 1, 3, 1, 6, 4, 7};
    	int[] a1 = new int[]{3, 2, 1, 4, 3};
    	FindDuplicateNumber f = new FindDuplicateNumber();
    	int b = f.findDuplicate1(a1);
    	System.out.println(b);
    }
    
    
}
