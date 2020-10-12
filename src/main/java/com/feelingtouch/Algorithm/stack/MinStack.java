package com.feelingtouch.Algorithm.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 * 
 * @author admin
 *
 */
public class MinStack {
    /** initialize your data structure here. */
	
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
    public MinStack() {
    }
    
    public void push(int x) {
    	stack.push(x);
    	int min;
    	if(minStack.isEmpty()){
    		min = Integer.MAX_VALUE;
    	} else{
    		min = minStack.peek();
    	}
    	min = Math.min(min, x);
    	minStack.push(min);
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
    
    public static void main(String[] args){
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	minStack.getMin();  //返回 -3.
    	minStack.pop();
    	minStack.top();      //返回 0.
    	minStack.getMin();   //返回 -2.

    }
}
