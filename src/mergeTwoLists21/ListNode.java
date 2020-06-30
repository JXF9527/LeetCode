package mergeTwoLists21;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 插队法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        if(l1.val < l2.val) {
            head = l1;
        }
        else {
            head = l2;
        }
        do{
            if(cur2.val <= cur1.val){
                while (cur2.next != null && cur2.next.val <= cur1.val){
                    cur2 = cur2.next;
                }
                l2 = cur2.next;
                cur2.next = cur1;
            }
            else {
                while (cur1.next != null && cur1.next.val < cur2.val){
                    cur1 = cur1.next;
                }
                l2 = cur2.next;
                cur2.next = cur1.next;
                cur1.next = cur2;
            }
            cur2 = l2;
        } while (cur2 != null);
        return head;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}

