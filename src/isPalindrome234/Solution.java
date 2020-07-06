package isPalindrome234;

import dataStructure.ListNode;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    /**
     * 暴力，O(n)时空
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        int len = list.size() / 2;
        for (int i = 0; i < len; ++i) {
            if(!list.get(i).equals(list.get(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针找中点，翻转后半链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //无论奇偶，slow.next是后半部分的起点
        fast = null;
        ListNode p = slow.next;
        while (p != null) {
            slow = p;
            p = p.next;
            slow.next = fast;
            fast = slow;
        }
        //此时fast是后半部分翻转链表头指针
        while (fast != null) {
            if(fast.val != head.val) {
                return false;
            }
            fast = fast.next;
            head = head.next;
        }

        return true;
    }
}
