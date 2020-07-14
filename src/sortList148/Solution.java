package sortList148;

import dataStructure.ListNode;

public class Solution {
    /**
     * O(nlogn)时间，归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return sortL(head);
    }

    private ListNode sortL(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode slow = node;
        ListNode fast = node;
        //快慢指针找中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortL(node), sortL(fast));

    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l == null)
            return  r;
        if (r == null)
            return l;
        ListNode pre = null, p, head = l.val < r.val ? l : r;
        while (true) {
            if (l.val < r.val) {
                p = l;
                l = l.next;
            }
            else {
                p = r;
                r = r.next;
            }

            if (pre != null)
                pre.next = p;

            if (l == null) {
                p.next = r;
                break;
            }

            if (r == null) {
                p.next = l;
                break;
            }

            pre = p;
        }

        return head;
    }
}
