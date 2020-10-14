package com.feelingtouch.Algorithm.tree;


/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * @author admin
 *
 */
public class NextRightPointer {
    public Node connect(Node root) {
        
    	if(root == null){
    		return null;
    	}
    	
    	if(root.left != null){
    		root.left.next = root.right;
    	}
    	
    	if(root.right != null && root.next != null){
    		root.right.next = root.next.left;
    	}
    	
    	connect(root.left);
    	connect(root.right);
    	
    	return root;
    }
}
