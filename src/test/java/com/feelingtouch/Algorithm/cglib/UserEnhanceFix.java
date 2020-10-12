package com.feelingtouch.Algorithm.cglib;

import net.sf.cglib.proxy.FixedValue;

public class UserEnhanceFix implements FixedValue{

	@Override
	public Object loadObject() throws Exception {
		System.out.println("before loadObj");
		return 50;
	}

}
