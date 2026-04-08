package priv.ana.algorithm;

import java.util.HashSet;

public class Solution149 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (listNodes.contains(cur)) return true;
            else listNodes.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCyclePlus(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
