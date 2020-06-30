package reverseList206;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    /**
     * 采用栈反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode newnode = null;
        if(head == null)
            return head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        head = stack.pop();
        head.next = null;
        p = head;
        while (!stack.empty()){
            newnode = stack.pop();
            newnode.next = null;
            p.next = newnode;
            p = newnode;
        }
        return head;
    }

    /**
     * 直接在链表上操作
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}