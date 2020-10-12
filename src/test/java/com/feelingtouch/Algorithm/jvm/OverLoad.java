package com.feelingtouch.Algorithm.jvm;

import java.io.Serializable;
import java.util.List;

/**
 * 重载方法匹配优先级
 * 编译期间选择静态分派目标
 * 
 * @author admin
 *
 */
public class OverLoad {
	public static void sayHello(Object arg) {
		System.out.println("hello Object");
	}

	public static void sayHello(int arg) {
		System.out.println("hello int");
	}

	public static void sayHello(long arg) {
		System.out.println("hello long");
	}

	public static void sayHello(Character arg) {
		System.out.println("hello Character");
	}

	public static void sayHello(char arg) {
		System.out.println("hello char");
	}

	public static void sayHello(char... arg) {
		System.out.println("hello char…");
	}

	public static void sayHello(Serializable arg) {
		System.out.println("hello Serializable");
	}
	
	public static void sayHello(Comparable<Character> arg) {
		System.out.println("hello Comparable");
	}

	public static void main(String[] args) {
		sayHello('a');
	}
}