package com.feelingtouch.Algorithm.array;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 思路：只加上升坡
 * 
 * @author admin
 *
 */
public class BestTime2BuyStock2 {
    public int maxProfit(int[] prices) {

    	if(prices.length == 0){
    		return 0;
    	}
    	
    	int maxProfit = 0;		// 利润和
    	int prePrice = prices[0];
    	
    	for(int price: prices){
    		// 一旦低于前一天价格，则增加maxProfit
    		if(price > prePrice){
    			// 上升坡
    			maxProfit += (price - prePrice);
    		} else{
    			// 下降坡
    		}
    		prePrice = price;
    	}
    	
    	return maxProfit;
    }
    
    public static void main(String [] args){
    	int [] a = new int[]{6, 9, 10, 7, 11, 3, 5};
    	BestTime2BuyStock2 s = new BestTime2BuyStock2();
		System.out.println(s.maxProfit(a));
    }
    
}
