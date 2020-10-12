package com.feelingtouch.Algorithm.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * @author admin
 *
 */
public class CoinChange {
	
	// 
    public int coinChange1(int[] coins, int amount) {
    	if(coins == null){
    		return -1;
    	}
    	if(amount == 0){
    		return 0;
    	}
    	
    	// 状态，i：硬币数；j：总额度
    	boolean[][] s = new boolean[amount+1][amount+1]; 
    	
    	// 边界条件
    	boolean allBig = true;
    	for(int coin: coins){
    		if(coin > amount){
    			
    		} else if(coin == amount){
    			return 1;
    		} else{
    			s[1][coin] = true;
    			allBig = false;
    		}
    	}
    	
    	if(allBig){
    		return -1;
    	}
    	
    	// 状态转移方程
    	for(int i=2; i<=amount; i++){
    		for(int j=0; j<=amount; j++){
    			if(s[i-1][j]){
    				for(int coin: coins){
    					int value = j + coin;
    					if(value == amount){
    						return i;
    					} else if(value < amount){
    						s[i][value] = true;
    					} else{
    						// 超的忽略
    					}
    				}
    			}
    		}
    	}
    	return -1;
    }
    
    // 自底向上dp
    public int coinChange(int[] coins, int amount) {
    	if(coins == null){
    		return -1;
    	}
    	
    	// s[i]表示凑成i的硬币数量的最少值
    	int[] s = new int[amount+1];
    	Arrays.fill(s, amount+1);			// 初始化成最大值，便于后面min操作
    	s[0] = 0;
    	
    	for(int i=1; i<=amount; i++){
    		for(int coin: coins){
    			if(i - coin >= 0){
    				s[i] = Math.min(s[i], s[i - coin] + 1);
    			}
    		}
    	}
    	
    	return (s[amount] >= amount+1)? -1 : s[amount];
    }
    
    public static void main(String [] args){
    	int [] a = new int[]{2,5,10,1};
    	CoinChange s = new CoinChange();
		System.out.println(s.coinChange(a, 27));
    }
    
}
