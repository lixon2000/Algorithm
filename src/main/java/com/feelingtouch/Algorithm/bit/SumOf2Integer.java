package com.feelingtouch.Algorithm.bit;

/**
 * 不用+-符号计算两数和
 * 思路：非进位使用异或，进位使用与后移位，而后再次加，到无进位为止
 * 
 * @author admin
 *
 */
public class SumOf2Integer {
	
    public int getSum(int a, int b) {
    	while(b != 0){
    		int tmp = a;
    		a = a ^ b;
    		b = (tmp & b) << 1;
    	}
    	return a;
    }
}
