package com.feelingtouch.Algorithm.sort;

import com.feelingtouch.Algorithm.list.ListNode;


/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author admin
 *
 */
public class SortList {
	
	/**
	 * 归并排序解法
	 * @author admin
	 *
	 */
	public static class SolutionMerge {
		public ListNode sortList(ListNode head) {
			return mergeSort(head);
		}
		
		private ListNode mergeSort(ListNode head){
			System.err.println("======== start sort: head" + ListNode.printSingleList(head));
			
			if(head == null || head.next == null){
				return head;
			}
			
			// 找中点
			ListNode fastP = head.next;
			ListNode slowP = head;
			while(fastP != null && fastP.next != null){
				fastP = fastP.next.next;
				slowP = slowP.next;
			}
			
			// 断开
			ListNode head2 = slowP.next;
			slowP.next = null;
			
			// 小区间排序
			head = mergeSort(head);
			head2 = mergeSort(head2);
			
			// 合并
			return merge(head, head2);
		}
		
		private ListNode merge(ListNode head1, ListNode head2){
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
			
			System.err.println("======== end sort merge: head" + ListNode.printSingleList(dummyNode.next));
			return dummyNode.next;
		}
		
	}
	
	
	
	/**
	 * 快速排序解法
	 * @author admin
	 *
	 */
	public static class SolutionQuick {
	    public ListNode sortList(ListNode head) {
	    	return quickSort(head);
	    }
	    
	    private ListNode quickSort(ListNode head){
	    	System.err.println("======== start sort: head" + ListNode.printSingleList(head));
	    	
	    	if(head == null || head.next == null){
	    		return head;
	    	}
	    	
	    	// 以head为pivot进行分区
	    	int x = head.val;
	    	ListNode ls = new ListNode(-999);
	    	ListNode lHead = ls;
	    	ListNode rs = new ListNode(-999);
	    	ListNode rHead = rs;
	    	ListNode cur = head;
	    	
	    	while(cur != null){
	    		if(cur.val < x){
	    			ls.next = cur;
	    			ls = cur;
	    		} else{
	    			rs.next = cur;
	    			rs = cur;
	    		}
	    		
	    		cur = cur.next;
	    	}
	    		    	
	    	
	    	rs.next = null;
//	    	ls.next = null;
	    	ls.next = rHead.next;
	    	
	    	System.out.println("ls" + ListNode.printSingleList(ls));
	    	System.out.println("lHead" + ListNode.printSingleList(lHead));
	    	System.out.println("rs" + ListNode.printSingleList(rs));
	    	System.out.println("rHead" + ListNode.printSingleList(rHead));
	    	System.out.println("[head]" + ListNode.printSingleList(head));
	    	
	    	// 分别对左右两部分递归
	    	ListNode right = quickSort(head.next);
	    	head.next = null;
	    	ListNode left = quickSort(lHead.next);
	    	
	    	System.out.println("left " + ListNode.printSingleList(left));
	    	System.out.println("right " + ListNode.printSingleList(right));
	    	
	    	// 左右连接到一起
	    	cur = left;
	    	while(cur.next != null){
	    		cur = cur.next;
	    	}
	    	cur.next = right;
	    	
	    	System.out.println("======== end sort: head" + ListNode.printSingleList(head));
	    	return left;
	    }
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
        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println("### sort start: " + ListNode.printSingleList(head));
//		SolutionQuick s = new SolutionQuick();
//		ListNode sortNode = s.quickSort(head);
        SolutionMerge s = new SolutionMerge();
		ListNode sortNode = s.sortList(head);
		System.out.println("### sort end: " + ListNode.printSingleList(sortNode));
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
