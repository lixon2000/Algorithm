package com.feelingtouch.Algorithm.tree;


/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 
 * @author admin
 *
 */
public class ConvertSortedArray2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
    	int length = nums.length;
    	TreeNode root = sortedArrayToBST(nums, 0, length-1);
    	return root;
    }
    
    // 索引从l到r的nums数组，转成BST
    private TreeNode sortedArrayToBST(int[] nums, int l, int r){
    	if(l > r){
    		return null;
    	} else if(l == r){
    		return new TreeNode(nums[l]);
    	} else{
    	}
    	
    	int mid = (l+r)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = sortedArrayToBST(nums, l, mid-1);
    	root.right = sortedArrayToBST(nums, mid+1, r);
    	return root;
    }
    
    public static void main(String [] args){
    	
    	int [] a = new int[]{1, 2, 5, 6};
    	ConvertSortedArray2BST s = new ConvertSortedArray2BST();
		TreeNode t = s.sortedArrayToBST(a);
		System.out.println(t);
    }
}
