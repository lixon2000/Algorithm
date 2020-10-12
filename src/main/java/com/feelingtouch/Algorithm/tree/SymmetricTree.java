package com.feelingtouch.Algorithm.tree;


/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @author admin
 *
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right){
    	if(left == null && right == null){
    		return true;
    	}
    	
    	if(left == null || right == null){
    		return false;
    	}
    	
    	if(left.val != right.val){
    		return false;
    	}
    	
    	return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(2);
	    node1.left = node2;
	    node1.right = node3;
	    node2.left = node4;
	    node3.left = node5;
	    
	    SymmetricTree qs = new SymmetricTree();
	    boolean a = qs.isSymmetric(node1);
		System.out.println(a);
	}
    
    
    
}
