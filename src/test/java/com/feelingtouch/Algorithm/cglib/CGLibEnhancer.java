package com.feelingtouch.Algorithm.cglib;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 动态代理
 * 在原始类和接口还未知的时候，就确定代理类的代理行为，
 * 当代理类与原始类脱离直接联系后，就可以很灵活地重用于不同的应用场景之中
 * 
 * @author admin
 *
 */
public class CGLibEnhancer {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object create(Class<?> objectClass){
		enhancer.setSuperclass(objectClass);
		enhancer.setCallback(new UserEnhancerCallBack());
//		enhancer.setCallback(new UserEnhanceFix());
		Object o = enhancer.create();
		return o;
	}
	public Object create1(Class<?> objectClass){
		enhancer.setSuperclass(objectClass);
		
		CallbackHelper callbackHelper = new CallbackHelper(objectClass, null) {
			@Override
			protected Object getCallback(Method method) {
			     if(method.getName().startsWith("get") || method.getName().startsWith("set")){
			    	 return NoOp.INSTANCE;
		         }else{
		        	 return new UserEnhancerCallBack();
		         } 
			}
		};
		
		enhancer.setCallbackFilter(callbackHelper);
		enhancer.setCallbacks(callbackHelper.getCallbacks());
		
		Object o = enhancer.create();
		
		return o;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		CGLibEnhancer aop = new CGLibEnhancer();
		UserBean userBean = (UserBean) aop.create(UserBean.class);
//		UserBean user2 = (UserBean) aop.create(UserBean.class);
		
		userBean.getUid();
		userBean.hitTool();
		int fight = userBean.fight();
//		user2.hide();
//		user2.fight();
		System.out.println(fight);
		
		// Immutable
//		{
//			UserBean userBean9 = new UserBean();
//			UserBean immBean = (UserBean) ImmutableBean.create(userBean9);
//			immBean.getName();
//		}
//		{
//			UserBean userBean9 = new UserBean();
//		    BeanCopier copier = BeanCopier.create(UserBean.class, MostBean.class, false);//设置为true，则使用converter
//		    userBean9.setName("name@w");
//		    MostBean otherBean = new MostBean();
//		    copier.copy(userBean9, otherBean, null); //设置为true，则传入converter指明怎么进行转换
//		    System.out.println(otherBean.getName());
//		}
//		
//		{
//			BeanGenerator beanGenerator = new BeanGenerator();
//		    beanGenerator.addProperty("name",String.class);
//		    Object userBean1 = beanGenerator.create();
//		    Method setter = userBean1.getClass().getMethod("setName",String.class);
//		    setter.invoke(userBean1,"Hello cglib");
//		    Method getter = userBean1.getClass().getMethod("getName");
//		    System.out.println(getter.invoke(userBean1, args));
//		}
		
	}
	
	
}
