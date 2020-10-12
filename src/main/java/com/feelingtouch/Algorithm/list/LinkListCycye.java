package com.feelingtouch.Algorithm.list;

/**
 * 141. 环形链表
 * @author admin
 *
 */
public class LinkListCycye {
    public boolean hasCycle(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;

        while(fastP != null){
            slowP = slowP.next;
            fastP = fastP.next;
            
            if(fastP != null){
                fastP = fastP.next;
            } else{
            }
            
            if(slowP == null || fastP == null){
                break;
            }
            if(slowP == fastP){
                return true;
            }
        }
        
        return false;
    }
}
