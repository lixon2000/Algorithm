package com.feelingtouch.Algorithm.list;


/**
 * 两个有序两边合并
 * @author admin
 *
 */
public class ListMerge {
	public ListNode merge(ListNode head1, ListNode head2){
		ListNode dummyNode = new ListNode(-1);
		ListNode cur = dummyNode;
		
		while(head1 != null && head2 != null){
			if(head1.val <= head2.val){
				cur.next = head1;
				head1 = head1.next;
			} else{
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		
		if(head1 == null){
			cur.next = head2;
		}
		
		if(head2 == null){
			cur.next = head1;
		}
		
		return dummyNode.next;
	}
	
	public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        
        
        System.out.println("### start: " + ListNode.printSingleList(node1));
        System.out.println("### start: " + ListNode.printSingleList(node2));
        ListMerge s = new ListMerge();
		ListNode sortNode = s.merge(node2, node1);
		System.out.println("### end: " + ListNode.printSingleList(sortNode));
		
	}
}
