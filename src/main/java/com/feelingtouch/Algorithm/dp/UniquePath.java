package com.feelingtouch.Algorithm.dp;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 
 * 
 * @author admin
 *
 */
public class UniquePath {
    public int uniquePaths1(int m, int n) {
    	
    	int[][] s = new int[m][n];
    	s[0][0] = 1;
    	for(int i=0; i<m; i++){
    		s[i][0] = 1;
    	}
    	for(int i=0; i<n; i++){
    		s[0][i] = 1;
    	}
    	
    	// 状态转移方程
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			s[i][j] = s[i][j-1] + s[i-1][j];
    		}
    	}
    	
    	return s[m-1][n-1];
    }
    
    // 优化，将m行每行在上一行上面叠加
    public int uniquePaths(int m, int n) {
    	
    	int[] s = new int[n];
    	for(int i=0; i<n; i++){
    		s[i] = 1;
    	}
    	
    	// 状态转移方程
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			s[j] += s[j-1];
    		}
    	}
    	
    	return s[n-1];
    }
    
    public static void main(String [] args){
    	UniquePath s = new UniquePath();
		System.out.println(s.uniquePaths(3,4));
    }
}
