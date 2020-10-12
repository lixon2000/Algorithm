package com.feelingtouch.Algorithm.array;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 
 * 思路：为每个值算出相对于前面最低点的差
 * 
 * @author admin
 *
 */
public class BestTime2BuyStock {
    public int maxProfit(int[] prices) {

    	int maxProfit = 0;
    	int minPrice = Integer.MAX_VALUE;
    	for(int price: prices){
    		minPrice = Math.min(minPrice, price);
    		int profit = price - minPrice;
    		if(profit > maxProfit){
    			maxProfit = profit;
    		}
    	}
    	
    	return maxProfit;
    }
    
    public static void main(String [] args){
    	int [] a = new int[]{6, 6, 9, 10, 7, 11, 3, 5};
    	BestTime2BuyStock s = new BestTime2BuyStock();
		System.out.println(s.maxProfit(a));
    }
    
}
