package mergeKLists23;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
     * 两两合并链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    /**
     * 排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        List<ListNode> list = new ArrayList<>();
        ListNode p, head = null;
        for (int i = 0 ;i < lists.length; i++) {
            p = lists[i];
            while (p != null) {
                list.add(p);
                p = p.next;
            }
        }

        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        p = null;
        for (ListNode node : list) {
            if (head == null) {
                head = node;
                p = head;
                continue;
            }
            p.next = node;
            node.next = null;
            p = node;
        }

        return head;
    }

    /**
     * 分治
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        else if (lists.length == 1)
            return lists[0];
        else if (lists.length == 2)
            return mergeTwoLists(lists[0], lists[1]);
        int mid = lists.length >> 1;
        int i;
        ListNode[] l1 = new ListNode[mid];

        for (i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length - mid];

        for (i = 0; i < lists.length - mid; i++) {
            l2[i] = lists[i + mid];
        }

        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
