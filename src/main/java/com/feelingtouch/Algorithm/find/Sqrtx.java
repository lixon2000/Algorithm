package com.feelingtouch.Algorithm.find;

/**
 * 69. x 的平方根
 * 
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * @author admin
 *
 */
public class Sqrtx {
	
    public int mySqrt(int x) {
    	int l = 1;
    	int r = x>>1;
    	
    	while(l <= r){
    		int mid = l + ((r-l)>>1);	// 中点
            if((long)mid*mid == x){
    			return mid;
    		} else if((long)mid*mid > x){
    			r = mid - 1;
    		} else{
    			l = mid + 1; 
    		}
    	}
    	
    	if((long)l*l>x){
    		l = l-1;
    	}
    	return l;
    }
    
    // 更好的写法
    public int mySqrt1(int x) {
    	int l = 0;
    	int r = x;
    	int ans = -1;
    	
    	while(l <= r){
    		int mid = l + ((r-l)>>1);	// 中点
    		if((long)mid*mid > x){
    			r = mid - 1;
    		} else{
    			ans = mid;			// 关键是这句，在小于x时记录下mid，可以获得比x的平方根小的那个整数
    			l = mid + 1; 
    		}
    	}
    	
    	return ans;
    }
    
    public static void main(String [] args){
    	int a = 2147395599;
    	Sqrtx s = new Sqrtx();
		s.mySqrt(a);
    }
}
