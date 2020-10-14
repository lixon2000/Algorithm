package com.feelingtouch.Algorithm.tree;

/**
 * 
 * 236. 二叉树的最近公共祖先
 * 
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 
 * 思路：寻找公共祖先，必然要通过两个节点向根方向查找，但没有指向父节点的指针，
 * 因此，使用两种方式：
 * 1 遍历树，遍历时记录每个节点的父节点，然后从p和q向根查找共同祖先；
 * 2 递归，归的过程便是从下向上找的过程，要从p或q向上标记为p或q的祖先，如果是p的祖先，则标记为p，如果是q的，则标记为q，如果是共同的，就找到了
 * 
 * 
 * @author admin
 *
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
    	
    	// 没找到
    	if(root == null){
    		return null;
    	}
    	
    	// 找到
    	if(root == p || root == q){
        	return root;
        }
    	
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(left == null && right == null){
    		return null;
    	}
    	
    	if(left == null){
        	return right;
        }
    	
    	if(right == null){
    		return left;
    	}
    	
    	return root;
    }
}
