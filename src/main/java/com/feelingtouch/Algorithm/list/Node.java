package com.feelingtouch.Algorithm.list;



public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    
	
    public static String printSingleList(Node head){
    	Node cur = head;
    	String listStr = "";
        while(cur != null){
        	listStr += "->"+ cur.val;
        	cur = cur.next;
        }
        return listStr;
//        System.out.println("list:" + listStr);
    }
    
}
