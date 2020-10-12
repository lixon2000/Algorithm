package com.feelingtouch.Algorithm.jvm;

public class Boxing {
	public static void main(String[] args) {
		Integer a=1;
		Integer b=2;
		Integer c=3;		// IntegerCache
		Integer d=3;		// IntegerCache
		Integer e=321;
		Integer f=321;
		Long g=3L;
		
		// ==不遇到运算符不拆箱
		System.out.println(c==d);			// cache
		System.out.println(e==f);			// 不在cache
		System.out.println(c==(a+b));		// 拆箱，==比较值
		System.out.println(c.equals(a+b));	// a+b前拆箱，之后装箱查cache，==比较Integer对象
		System.out.println(g==(a+b));		// g拆箱，a+b前拆箱
		System.out.println(g.equals(a+b));
	}
}
