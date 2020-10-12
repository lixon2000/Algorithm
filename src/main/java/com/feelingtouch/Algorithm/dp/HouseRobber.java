package com.feelingtouch.Algorithm.dp;

import java.util.HashMap;
import java.util.Map;


/**
 * 198. 打家劫舍
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * @author admin
 *
 */
public class HouseRobber {
    public int rob1(int[] nums) {
    	int n = nums.length;
    	if(n == 0){
    		return 0;
    	}
    	
    	int v = 400*n;		// 最大价值
    	int[][] s = new int[n][v+1];

    	// 初始化第0行，状态中，1表示选中了，本次不能选，2表示前一次选中了，本次不能选
    	s[0][0] = 1;
    	if(s[0][nums[0]] == 0){
    		s[0][nums[0]] = 2;
    	}
    	
        for(int i=1; i<n; i++){
        	// 本次决策不选中，保留前面的决策，并置为1
        	for(int j=0; j<=v; j++){
        		if(s[i-1][j] == 2 || s[i-1][j] == 1){
        			s[i][j] = 1;
        		}
        	}
        	
        	// 上次为2的，本次不能加，上次为1的，本次要加
        	for(int j=0; j<=v; j++){
        		if(s[i-1][j] == 1 && s[i][j+nums[i]] == 0){
        			s[i][j+nums[i]] = 2;
        		}
        	}
        }
        
        // 找最后一行最大的v
        for(int i=v; i>0; i--){
        	if(s[n-1][i] != 0){
        		return i;
        	}
        }
        
        return 0;
    }
    
    // 标准解法
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	if(nums.length == 1){
    		return nums[0];
    	}
    	
    	// 状态定义，表示rob第i个后获得的最大金额
    	int[] s = new int[nums.length]; 
    	
    	// 边界
    	s[0] = nums[0];
    	s[1] = Math.max(nums[0], nums[1]);
    	
    	// 状态转移方程
    	for(int i=2; i<nums.length; i++){
    		s[i] = Math.max(s[i-1], s[i-2]+ nums[i]);
    	}
    	
    	return s[nums.length -1];
    }
    
    
    public int rob2(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	return rob(nums, nums.length-1);
    }
    
    private Map<Integer, Integer> sMap = new HashMap<>();
    
    // 从start开始
    private int rob(int[] nums, int start){
    	if(sMap.containsKey(start)){
    		return sMap.get(start);
    	}
    	if(start == 0){
    		return nums[0];
    	}
    	if(start == 1){
    		return Math.max(nums[0], nums[1]);
    	}
    	
    	int value = Math.max(rob(nums, start-1), rob(nums, start-2)+nums[start]);
    	sMap.put(start, value);
    	return value;
    }
    
    public static void main(String [] args){
    	int [] a = new int[]{1,6,1,1,6,1};
    	HouseRobber s = new HouseRobber();
		System.out.println(s.rob2(a));
    }
}
