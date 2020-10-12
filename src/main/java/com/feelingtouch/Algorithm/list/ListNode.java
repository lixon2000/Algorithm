package com.feelingtouch.Algorithm.list;



public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    
	
    public static String printSingleList(ListNode head){
    	ListNode cur = head;
    	String listStr = "";
        while(cur != null){
        	listStr += "->"+ cur.val;
        	cur = cur.next;
        }
        return listStr;
//        System.out.println("list:" + listStr);
    }
    
}
