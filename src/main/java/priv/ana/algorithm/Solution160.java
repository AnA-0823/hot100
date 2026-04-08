package priv.ana.algorithm;

import java.util.HashSet;

public class Solution160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            listNodes.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (listNodes.contains(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }

    public ListNode getIntersectionNodePlus(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
