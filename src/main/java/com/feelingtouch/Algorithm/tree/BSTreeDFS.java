package com.feelingtouch.Algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * @author admin
 *
 */
public class BSTreeDFS {
    public boolean dfs(TreeNode root) {
    	List<Integer> values = new ArrayList<>();
    	addTreeValue(root, values);
    	return true;
    }
    
    // 将root的左右子树的value全部加进来
    private void addTreeValue(TreeNode root, List<Integer> values){
    	if(root == null){
    		return;
    	}
    	
    	addTreeValue(root.left, values);
    	values.add(root.val);
    	addTreeValue(root.right, values);
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
	    
	    BSTreeDFS qs = new BSTreeDFS();
	    boolean a = qs.dfs(node1);
		System.out.println(a); 
	}
    
    
    
}
