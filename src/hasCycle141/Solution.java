package hasCycle141;

import dataStructure.*;

import java.util.*;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * Set
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 破坏数据，标记法
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode t;
        while (head != null){
            if(head.next == node){
                return true;
            }
            t = head;
            head = head.next;
            t.next = node;
        }
        return false;
    }
}
