package com.feelingtouch.Algorithm.sort;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 链表分拆，再拼接
 * 
 * @author admin
 *
 */
public class PartitionList {

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public static class Solution {
	    public ListNode partition(ListNode head, int x) {
	    	if(head == null || head.next == null){
	    		return head;
	    	}
	    	
	    	ListNode ls = new ListNode(-1);
	    	ListNode lHead = ls;
	    	ListNode rs = new ListNode(-1);
	    	ListNode rHead = rs;
	    	
	    	while(head != null){
	    		if(head.val < x){
	    			ls.next = head;
	    			ls = head;
	    		} else{
	    			rs.next = head;
	    			rs = head;
	    		}
	    		
	    		head = head.next;
	    	}
	    	
	    	rs.next = null;
	    	ls.next = rHead.next;
	    	return lHead.next;
	    }
	}
	
    
	public static void main(String[] args) {
		Solution s = new Solution();

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
