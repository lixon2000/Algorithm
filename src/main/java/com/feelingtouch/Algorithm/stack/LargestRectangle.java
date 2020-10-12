package com.feelingtouch.Algorithm.stack;

import java.util.Stack;


/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * @author admin
 *
 */
public class LargestRectangle {

	// 暴力解法
    public int largestRectangleArea(int[] heights) {
    	int largestArea = 0;
    	
    	for(int i=0; i<heights.length; i++){
    		int height = heights[i];
    		// 对每个高度向前后两个方向找
    		// 向前
    		int j=i-1;	// 下限
    		while(j>=0){
    			if(heights[j] >= height){
    				j--;
    			} else{
    				break;
    			}
    		}
    		// 向后
    		int k=i+1;
    		while(k<heights.length){
    			if(heights[k] >= height){
    				k++;
    			} else{
    				break;
    			}
    		}
    		// 加起来计算矩形长度和面积
    		int area = (k-1-(j+1)+1)*height;
    		largestArea = Math.max(area, largestArea);
    	}

    	return largestArea;
    }
    
    // 用辅助数组和单调栈，存储每个height前面比其小的第一个i，和后面比其小的第一个i
    public int largestRectangleArea1(int[] heights) {
    	int n = heights.length;
    	int[] right = new int[n];
    	int[] left = new int[n];
    	for(int i=0; i<n; i++){
    		right[i] = n;
    		left[i] = -1;
    	}
    	
    	Stack<Integer> stack = new Stack<>();
    	for(int i=0; i<n; i++){
    		// 空了就push，否则比较新元素和栈顶元素，新元素小的话，全部出站
    		while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
    			int cur = stack.pop();
    			right[cur] = i;
    		}
    		stack.push(i);
    	}
    	
    	stack.clear();
    	for(int i=n-1; i>=0; i--){
    		while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
    			int cur = stack.pop();
    			left[cur] = i;
    		}
    		stack.push(i);
    	}
    	
    	int largestArea = 0;
    	for(int i=0; i<n; i++){
    		int area = (right[i] - left[i] - 1) * heights[i];
    		largestArea = Math.max(area, largestArea);
    	}
    	
    	return largestArea;
    }
    
	public static void main(String[] args) {
		LargestRectangle s = new LargestRectangle();
		int[] heights = new int[]{2,1,5,6,3,7,4};
		System.out.println(s.largestRectangleArea(heights));
		System.out.println(s.largestRectangleArea1(heights));
		
		String s2 = new String("java");
		System.out.println(s2.intern() == s2);
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1.intern() == s1);
	}
    
}
