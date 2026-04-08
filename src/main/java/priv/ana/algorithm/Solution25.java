package priv.ana.algorithm;

public class Solution25 {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode prehead = new ListNode(-1, head);
        ListNode cur = prehead;
        while (checkHasNextKNode(cur, k)) {
            ListNode temp = cur.next;
            for (int i = 0; i < k; i++) {
                temp = temp.next;
            }
            cur = reverseNextKNode(cur, k, temp);
        }
        return prehead.next;
    }

    private boolean checkHasNextKNode(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            if (node.next == null) return false;
            node = node.next;
        }
        return true;
    }

    private ListNode reverseNextKNode(ListNode node, int k, ListNode tail) {
        ListNode res = node.next;
        ListNode prev = tail;
        ListNode cur = node.next;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node.next = prev;
        return res;
    }
}
