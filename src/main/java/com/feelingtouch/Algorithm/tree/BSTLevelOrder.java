package com.feelingtouch.Algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * @author admin
 *
 */
public class BSTLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	LinkedList<List<Integer>> retList = new LinkedList<List<Integer>>();
    	if(root == null){
    		return retList;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		List<Integer> levelList = new LinkedList<>();
    		
    		// 关键是这里，使用queue的size作为遍历次数，获得该层的所有node
    		for(int i=0; i<size; i++){
    			TreeNode cur = queue.poll();
    			
    			// 打印cur
    			levelList.add(cur.val);
    			
    			if(cur.left != null){
    				queue.offer(cur.left);
    			}
    			if(cur.right != null){
    				queue.offer(cur.right);
    			}
    		}
    		retList.add(levelList);
    	}
    	
    	return retList;
    }
    
    
}
