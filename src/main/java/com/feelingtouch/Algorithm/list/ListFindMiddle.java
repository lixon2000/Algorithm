package com.feelingtouch.Algorithm.list;


/**
 * 找到链表中间节点
 * @author admin
 *
 */
public class ListFindMiddle {


    public ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode fastP = head.next;
		ListNode slowP = head;
		while(fastP != null && fastP.next != null){
			fastP = fastP.next.next;
			slowP = slowP.next;
		}
        
        return slowP;
    }
    
	public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(1);
        ListNode node10 = new ListNode(10);
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node10;
        
        System.out.println("### start: " + ListNode.printSingleList(head));
        ListFindMiddle s = new ListFindMiddle();
		ListNode sortNode = s.findMiddle(head);
		System.out.println("### end: " + ListNode.printSingleList(sortNode));
		

	}

    
}
