package com.feelingtouch.Algorithm.list;

/**
 * 反转链表
 * @author admin
 *
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
//		if(head == null || head.next == null){
//			return head;
//		}
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null){
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
    }
}
