package com.feelingtouch.Algorithm.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author admin
 *
 */
public class JDKProxy implements InvocationHandler{
	
	private Object originalObj;
	public Object bind(Object originalObj){
		this.originalObj = originalObj;
		return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("welcome");
		return method.invoke(originalObj, args);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		JDKProxy handler = new JDKProxy();
		UserBean userBean1 = new UserBean();
		
		IUserBean userBean2 = (IUserBean)handler.bind(userBean1);
		userBean2.hitTool();
		
		System.out.println(userBean2);
		
	}
	
	
}
