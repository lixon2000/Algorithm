package com.feelingtouch.Algorithm.list;

/**
 * 237. 删除链表中的节点
 * 
 * 
 * @author admin
 *
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
    
    public static void main(String[] args){
    	
    }
}
