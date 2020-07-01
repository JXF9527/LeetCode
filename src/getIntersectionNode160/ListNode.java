package getIntersectionNode160;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    /**
     * O(n)时间，O(1)空间，保持原有链表结构
     * 调整长度法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int lenA = 0;
        int lenB = 0;
        int sub = 0;
        while (cur != null){
            ++lenA;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null){
            ++lenB;
            cur = cur.next;
        }
        if(lenA > lenB){
            sub = lenA - lenB;
            while (sub-- > 0)
                headA = headA.next;
        }
        else if(lenA < lenB){
            sub = lenB - lenA;
            while (sub-- > 0)
                headB = headB.next;
        }
        //现在两长度相同的链表同时遍历
        cur = headA;
        ListNode p = headB;
        ListNode ans = null;
        while (cur != null){
            if(cur == p){
                ans = cur;
                break;
            }
            cur = cur.next;
            p = p.next;
        }
        return ans;
    }

    /**
     * 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     * 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = (pa == null ? headB : pa.next);
            pb = (pb == null ? headA : pb.next);
        }
        return pa;
    }
}


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

