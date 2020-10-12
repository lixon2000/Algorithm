package com.feelingtouch.Algorithm.bit;

/**
 * 191. 位1的个数
 * @author admin
 *
 */
public class NumberOf1Bit {

    public int hammingWeight(int n) {
    	int cnt = 0;
    	
    	// 移位
    	if((n & 1) == 1){
    		cnt ++;
    	}
    	
        for(int i=1; i<32; i++){
        	// 移位
        	n = n >>> 1;
        	if((n & 1) == 1){
        		cnt ++;
        	}
        }
        return cnt;
    }
    
    public static void main(String [] args){
    	int n = -2125234247;
    	NumberOf1Bit c = new NumberOf1Bit();
    	System.out.println(c.hammingWeight(n));
    }
    
    
}
