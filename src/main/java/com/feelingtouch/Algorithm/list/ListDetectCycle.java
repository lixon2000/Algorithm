package com.feelingtouch.Algorithm.list;

/**
 * 链表找环，找到后，返回环的入口
 * 
 * @author admin
 *
 */
public class ListDetectCycle {

	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 public static class Solution {
		    public ListNode detectCycle(ListNode head) {
		        
		    	if(head == null || head.next == null){
		    		return null;
		    	}
		    	
		    	// 两个指针
		    	ListNode slow = head;
		    	ListNode fast = head;
		    	while(fast != null){
		    		
		    		// slow走一步
		    		slow = slow.next;
		    		
		    		// fast走两步
		    		fast = fast.next;
		    		if(fast != null){
		    			fast = fast.next;
		    		}
		    		
		    		if(slow == fast){
		    			break;
		    		}
		    	}
		    	
		    	if(fast == null){
		    		return null;
		    	}
		    	
		    	// 此时slow是相遇点
		    	
		    	// 找入口
		    	fast = head;
		    	while(fast != slow){
		    		fast = fast.next;
		    		slow = slow.next;
		    	}
		    	
		    	return slow;
		    }
		}
	
	
    
	public static void main(String[] args) {

		
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l1;
		
		Solution s = new Solution();
		ListNode n = s.detectCycle(l0);
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
