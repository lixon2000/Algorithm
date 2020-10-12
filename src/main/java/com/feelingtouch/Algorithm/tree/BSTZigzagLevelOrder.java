package com.feelingtouch.Algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * @author admin
 *
 */
public class BSTZigzagLevelOrder {

	class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    	List<List<Integer>> retList = new ArrayList<>();
	    	if(root == null){
	    		return retList;
	    	}
	    	
	    	Stack<TreeNode> stack = new Stack<>();
	    	Queue<TreeNode> queue = new LinkedList<>();
	    	boolean left2Right = true;		// 表示是否左到右
	    	
	    	// 先进栈，然后全部出栈；出栈元素打印，进入队列；出队列的节点找子节点
	    	queue.offer(root);
	    	while(!queue.isEmpty() || !stack.isEmpty()){
	    		
	    		List<Integer> levelList = new ArrayList<>();
	    		
	    		while(!queue.isEmpty()){
	    			TreeNode curNode = queue.poll();
	    			levelList.add(curNode.val);
	    			
	    			if(left2Right){
	    				if(curNode.left != null){
	    					stack.push(curNode.left);
	    				}
	    				if(curNode.right != null){
	    					stack.push(curNode.right);
	    				}
	    			} else{
	    				if(curNode.right != null){
	    					stack.push(curNode.right);
	    				}
	    				if(curNode.left != null){
	    					stack.push(curNode.left);
	    				}
	    			}
	    		}
	    		
	    		left2Right = !left2Right;
	    		retList.add(levelList);
	    		
	    		while(!stack.isEmpty()){
	    			TreeNode curNode = stack.pop();
	    			queue.offer(curNode);
	    		}
	    	}
	    	
	    	return retList;
	    }
	}
	
}
