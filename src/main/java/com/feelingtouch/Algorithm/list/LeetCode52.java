package com.feelingtouch.Algorithm.list;



public class LeetCode52 {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    	ListNode a = headA;
	    	ListNode b = headB;
	    	while(a != b){
	    		a = (a != null)? a.next: headB;
	    		b = (b != null)? b.next: headA;
	    	}
	    	return a;
	    }
	}
	
    
	public static void main(String[] args) {
		
		LeetCode52 l = new LeetCode52();
		
//		System.out.println(content);
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
