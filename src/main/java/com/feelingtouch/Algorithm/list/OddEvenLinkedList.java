package com.feelingtouch.Algorithm.list;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 
 * @author admin
 *
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        
    	ListNode oddHead = new ListNode(-1);
    	ListNode evenHead = new ListNode(-1);
    	ListNode odd = oddHead;
    	ListNode even = evenHead;
    	ListNode cur = head;
    	int cnt = 1;
    	while(cur != null){
    		if((cnt & 1) == 1){
    			// odd
    			odd.next = cur;
    			odd = odd.next;
    		} else{
    			// even
    			even.next = cur;
    			even = even.next;
    		}
    		
    		cnt ++;
    		cur = cur.next;
    	}
    	even.next = null;
    	odd.next = evenHead.next;
    	
    	return oddHead.next;
    }
}
