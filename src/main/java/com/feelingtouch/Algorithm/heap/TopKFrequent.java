package com.feelingtouch.Algorithm.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 四种解法：快排变形、计数排序、堆、二叉搜索树
 * 
 * @author admin
 *
 */
public class TopKFrequent {
	
	// 堆
    public int[] topKFrequent(int[] nums, int k) {
    	// 统计频率
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num: nums){
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	Comparator<Integer> c = new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}};
    	
    	Queue<Integer> pq = new PriorityQueue<>(c);
    	for(int num: map.keySet()){
    		pq.offer(num);
    	}
    	
    	int[] topK = new int[k];
    	for(int i=0; i<k; i++){
    		topK[i] = pq.poll();
    	}
    	
    	return topK;
    }
    
    // 计数排序
    public int[] topKFrequent1(int[] nums, int k) {
    	// 统计频率
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num: nums){
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	// 桶，个数为n+1
    	List<Integer>[] cnt = new List[nums.length + 1];
    	for(int i=0; i<cnt.length; i++){
    		cnt[i] = new ArrayList<>();
    	}
    	
    	for(Entry<Integer, Integer> entry: map.entrySet()){
    		cnt[entry.getValue()].add(entry.getKey());
    	}
    	
    	// 按照从大到小找
    	int[] topK = new int[k];
    	int size = 0;
    	for(int i=cnt.length-1; i>=0; i--){
    		for(int num: cnt[i]){
    			topK[size] = num;
    			size ++;
    			if(size >= k){
    				return topK;
    			}
    		}
    	}
    	
    	return topK;
    }
    
    public static void main(String [] args){
    	int [] a = new int[]{2, 5, 6, 5, 9, 0, 0, 0, 9, 3, 2, 0, 1, 4, 0, 5, 4, 8};
    	TopKFrequent s = new TopKFrequent();
		s.topKFrequent(a, 5);
    }
}
