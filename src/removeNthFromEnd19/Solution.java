package removeNthFromEnd19;

import dataStructure.ListNode;

import java.util.*;

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
     * 额外空间
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode node, pre;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        node = list.get(list.size() - n);


        if (n == list.size()) {
            return list.get(0).next;
        }
        pre = list.get(list.size() - n - 1);

        pre.next = node.next;
        return list.get(0);
    }
    /*
     快慢指针，first先走n步，然后和second一起遍历
     */
}
