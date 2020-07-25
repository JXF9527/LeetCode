package detectCycle142;

import dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

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
     * 记录遍历过的结点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }


    /**
     * 不修改链表，空间O(1)，先用快慢指针p1,p2判断是否有环，p1每次走一步，p2每次走两步，如果相遇则有环，
     * 且p1走的步数为环的长度，设为k。接下来重新定义两个指针p3,p4指向head，p4先走k步，然后p3,p4一起走，
     * 相遇的节点为环的第一个节点。
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        int count = 0;
        ListNode fast = head, slow = head;
        //快慢指针判断是否有环
        while (fast != null && fast.next != null) {
            ++count;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环，此时环的长度的倍数为slow走过的距离
                fast = head;
                while (count-- > 0) {
                    fast = fast.next;
                }
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
