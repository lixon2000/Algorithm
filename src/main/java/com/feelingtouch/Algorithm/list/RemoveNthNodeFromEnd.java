package com.feelingtouch.Algorithm.list;


/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * @author admin
 *
 */
public class RemoveNthNodeFromEnd {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode slow = dummy;
    	ListNode fast = dummy;
    	
    	for(int i=0; i<=n; i++){
    		fast = fast.next;
    	}
    	
    	while(fast != null){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	// 删除slow.next
    	slow.next = slow.next.next;
    	
    	return dummy.next;
    }
}
