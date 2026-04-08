package priv.ana.algorithm;

public class Solution23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prehead = new ListNode();
        ListNode cur = prehead;
        while (check(lists)) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
            cur.next = lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return prehead.next;
    }

    public boolean check(ListNode[] curs) {
        for (ListNode cur : curs) {
            if (cur != null) return true;
        }
        return false;
    }
}
