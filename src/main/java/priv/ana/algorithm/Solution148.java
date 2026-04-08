package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Solution148 {
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

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (head != null) {
            integers.add(head.val);
            head = head.next;
        }
        Collections.sort(integers);
        ListNode prehead = new ListNode();
        ListNode cur = prehead;
        for (Integer integer : integers) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return prehead.next;
    }
}
