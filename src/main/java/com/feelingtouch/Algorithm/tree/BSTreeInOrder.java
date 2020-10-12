package com.feelingtouch.Algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 
 * @author admin
 *
 */
public class BSTreeInOrder {
	// 递归
   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root != null){
            traversal(root, resultList);
        }
        return resultList;
    }

    private void traversal(TreeNode node, List<Integer> resultList){
        if(node.left != null){
            traversal(node.left, resultList);
        }
        resultList.add(node.val);

        if(node.right != null){
            traversal(node.right, resultList);
        }
    }
    
    // 非递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(cur != null || stack.size() != 0){
        	
        	// 左子树全部入栈
        	while(cur != null){
        		stack.push(cur);
        		cur = cur.left;
        	}
        	
        	cur = stack.pop();
        	resultList.add(cur.val);		// 中间读
        	cur = cur.right;		// 换右边
        }
        
        return resultList;
    }
}
