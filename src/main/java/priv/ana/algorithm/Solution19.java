package priv.ana.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Solution19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = prehead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode preNode = stack.peek();
        assert preNode != null;
        preNode.next = preNode.next.next;
        return prehead.next;
    }
}
