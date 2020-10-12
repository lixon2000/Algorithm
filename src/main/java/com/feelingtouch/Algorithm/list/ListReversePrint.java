package com.feelingtouch.Algorithm.list;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * @author admin
 *
 */
public class ListReversePrint {


    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<>();

        while(head != null){
        	temp.add(head.val);
        	head = head.next;
        }
        
        int size = temp.size();
        int[] ret = new int[size];
        for(int j=0; j<size; j++){
        	ret[j] = temp.get(size-1-j);
        }
        
        return ret;
    }

    
}
