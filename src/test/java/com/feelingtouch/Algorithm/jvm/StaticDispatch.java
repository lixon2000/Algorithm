package com.feelingtouch.Algorithm.jvm;

/**
 * 静态类型在编译时就得知了
 * 
 * @author admin
 *
 */
public class StaticDispatch {
	static abstract class Human {
		protected abstract void sayHello();
	}

	static class Man extends Human {
		@Override
		protected void sayHello() {
			System.out.println("hello,gentleman！");
		}
	}

	static class Woman extends Human {
		@Override
		protected void sayHello() {
			System.out.println("hello,lady！");
		}
	}

	public void sayHello(Human guy) {
		System.out.println("hello,guy！");
	}

	public void sayHello(Man guy) {
		System.out.println("hello,gentleman！");
	}

	public void sayHello(Woman guy) {
		System.out.println("hello,lady！");
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
//		StaticDispatch sr = new StaticDispatch();
//		sr.sayHello(man);
//		sr.sayHello(woman);
		
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}

}
