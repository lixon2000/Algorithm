package com.feelingtouch.Algorithm.list;

/**
 * 138. 复制带随机指针的链表
 * 
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 
 * 
 * 
 * @author admin
 *
 */
public class CopyListWithRandom {
	
	// 在原节点后面加入新节点
    public Node copyRandomList(Node head) {
        
    	Node cur = head;
    	
    	// 加入新节点
    	while(cur != null){
    		Node node = new Node(cur.val);
    		node.next = cur.next;
    		cur.next = node;
    		cur = node.next;
    	}
    	
    	// 设置新节点的random
    	cur = head;
    	while(cur != null){
    		if(cur.random != null){
    			cur.next.random = cur.random.next;
    		}
    		cur = cur.next.next;
    	}
    	
    	cur = head;
    	Node dummy = new Node(-1);
    	Node newCur = dummy;
    	while(cur != null){
    		newCur.next = cur.next;
    		newCur = newCur.next;
    		
    		Node tmp = cur.next.next;
    		cur.next = tmp;
    		cur = tmp;
    	}
    	
    	return dummy.next;
    }
    
}
