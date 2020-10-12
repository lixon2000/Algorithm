package com.lx.gc;

import java.util.LinkedList;
import java.util.List;

public class GCTest {
	
	public static class GCBean{
		private int a;
		private String b;
		private List<Integer> c = new LinkedList<>();
		public GCBean(int a, String b) {
			super();
			this.a = a;
			this.b = b;
			for(int i=0;i<1000; i++){
				c.add(i);
			}
		}
	}

	public static void main(String [] args) throws InterruptedException{
		for(int i=0; i<10000; i++){
			GCBean bean = new GCBean(i, "name"+i);
		}
		System.out.println("construct end");
		
		Thread.sleep(Integer.MAX_VALUE);
	}
	
}
