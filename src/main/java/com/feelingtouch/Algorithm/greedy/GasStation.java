package com.feelingtouch.Algorithm.greedy;

/**
 * 
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 
 * 说明: 
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 
 * 
 * 贪心法，前缀和问题
 * 
 * 
 * 
 * @author admin
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int station = 0;
    	int n = gas.length;
    	
    	int totalGas = 0;		// 当遍历一遍后，如果为负，说明必然不能达到，返回-1
    	int curGas = 0;
    	for(int i=0; i<n; i++){
    		int surplus = gas[i] - cost[i];			// 每站过后增加的汽油，可以为负数
    		totalGas += surplus;
    		curGas += surplus;			// 相当于前缀和
    		
    		// 如果前缀和为负值，说明前面所有的i都无法满足条件，需要重新计算curGas，重置station
    		// 即，只要从整数开始叠加的前缀和，如果变为负数，则整段失效
    		// 这里是循环一遍的关键
    		if(curGas < 0){
    			curGas = 0;
    			station = i+1;
    		}
    	}
    	return (totalGas < 0)? -1: station;
    }
}
