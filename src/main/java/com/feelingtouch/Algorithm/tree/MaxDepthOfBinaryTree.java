package com.feelingtouch.Algorithm.tree;


/**
 * 104. 二叉树的最大深度
 * 
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * @author admin
 *
 */
public class MaxDepthOfBinaryTree {

	
    public int maxDepth(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	
    	// 递归
    	int depth = Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    	return depth;
    }
    
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		
	    node1.left = node2;
	    node1.right = node3;
	    node2.left = node4;
	    node2.right = node5;
	    node3.left = node6;
	    node3.right = node7;
	    node6.left = node8;
	        
	    
	    MaxDepthOfBinaryTree qs = new MaxDepthOfBinaryTree();
	    int a = qs.maxDepth(node1);
		System.out.println(a);
	}
    
    
}
