package priv.ana.algorithm;

import java.util.HashSet;

public class Solution142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (listNodes.contains(cur)) return cur;
            else listNodes.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
