package com.feelingtouch.Algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	 public static class Solution {
		    public int[][] merge(int[][] intervals) {
		    	if(intervals.length <= 0){
		    		return new int[][]{};
		    	}
		    	// 排序
		    	Arrays.sort(intervals, new Comparator<int[]>(){
					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[0] - o2[0];
					}
		    	});
		    	
		    	List<int[]> res = new ArrayList<>();
		    	res.add(intervals[0]);
		    	for(int i=1; i<intervals.length; i++){
		    		int[] peek = res.get(res.size() - 1);
		    		int[] curInterval = intervals[i];
		    		
		    		if(curInterval[0] <= peek[1]){
		    			// 合并
		    			peek[1] = Math.max(curInterval[1], peek[1]);
		    		} else{
		    			res.add(curInterval);
		    		}
		    	}
		    	
		    	return res.toArray(new int[res.size()][2]);
		    	
//		    	Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		    }
		}
    
	public static void main(String[] args) {
		int [][] intervals = new int[][]{{8,10},{1,9},{5,7},{15,17}};
		Solution s = new Solution();
		int [][] a = s.merge(intervals);

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
