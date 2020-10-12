package com.feelingtouch.Algorithm.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserEnhancerCallBack implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {

		System.out.println("before Obj" + obj.toString() + ", invoke" + method.toString());

//		Object ret = proxy.invoke(obj, args);
		Object ret = proxy.invokeSuper(obj, args);
		
		System.out.println("after Obj" + obj.toString() + ", invoke" + method);
		return ret;
	}

//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args)
//			throws Throwable {
//		System.out.println("before Obj" + proxy.toString() + ", invoke" + method.toString());
//		Object ret = method.invoke(proxy, args);
//		System.out.println("after Obj" + proxy.toString() + ", invoke" + method);
//		return ret;
//	}

}
