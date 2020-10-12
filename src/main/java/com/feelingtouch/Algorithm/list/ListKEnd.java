package com.feelingtouch.Algorithm.list;



/**
 * 链表中倒数第k个节点
 * @author admin
 *
 */
public class ListKEnd {


	class Solution22 {
	    public ListNode getKthFromEnd(ListNode head, int k) {
	    	ListNode front = head;	// 慢指针
	    	ListNode end = head;	// 快指针
	    	
	    	// end 先走k-1步
	    	for(int i=0; i<k-1; i++){
	    		if(end == null){
	    			return null;
	    		}
	    		end = end.next;
	    	}
	    	
	    	while(end.next != null){
	    		front = front.next;
	    		end = end.next;
	    	}
	    	
	    	return front;
	    }
	}

    
	public static void main(String[] args) {
		
		ListKEnd l = new ListKEnd();
		
//		System.out.println(content);
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
