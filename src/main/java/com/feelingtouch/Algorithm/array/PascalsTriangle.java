package com.feelingtouch.Algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * @author admin
 *
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> retList = new ArrayList<>();
    	if(numRows == 0){
    		return retList;
    	}
    	
    	retList.add(new ArrayList<>());
    	retList.get(0).add(1);
    	
    	for(int row=1; row<numRows; row++){
    		List<Integer> upRowList = retList.get(row - 1);	// 上一层
    		List<Integer> rowList = new ArrayList<>();		// 新的一层
    		for(int j=0; j<=row; j++){
    			int left = 0;
    			int right = 0;
    			
    			if(j != 0){
    				left = upRowList.get(j-1);
    			}
    			
    			if(j < upRowList.size()){
    				right = upRowList.get(j);
    			}
    			
    			rowList.add(left + right);
    		}
    		
    		retList.add(rowList);
    		upRowList = rowList;
    	}
    	return retList;
    }
    
    public static void main(String[] args) {
		PascalsTriangle s = new PascalsTriangle();
		List<List<Integer>> ll = s.generate(6);
		System.out.println(ll);
	}
    
}
