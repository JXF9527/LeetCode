package addTwoNumbers2;

import dataStructure.ListNode;

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
     * 遍历相加，形成新链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int sum;
        int count = 0;
        ListNode ans, pre = null;
        ListNode head = null;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + count;
            if (sum >= 10) {
                count = 1;
                sum -= 10;
            }
            else {
                count = 0;
            }

            ans = new ListNode(sum);
            if (pre != null)
                pre.next = ans;
            else
                head = ans;
            pre = ans;
            p1 = p1.next;
            p2 = p2.next;
        }


        if (p1 != null) {
            pre.next = p1;
            while (p1 != null) {
                sum = p1.val+ count;
                if (sum >= 10) {
                    count = 1;
                    sum -= 10;
                    p1.val = sum;
                }
                else {
                    count = 0;
                    p1.val = sum;
                    break;
                }
                pre = p1;
                p1 = p1.next;

            }

        }
        else if (p2 != null) {
            pre.next = p2;
            while (p2 != null) {
                sum = p2.val+ count;
                if (sum >= 10) {
                    count = 1;
                    sum -= 10;
                    p2.val = sum;
                }
                else {
                    count = 0;
                    p2.val = sum;
                    break;
                }
                pre = p2;
                p2 = p2.next;

            }

        }

        if (count == 1) {
            ans = new ListNode(count);
            pre.next = ans;
        }


        return head;
    }
}