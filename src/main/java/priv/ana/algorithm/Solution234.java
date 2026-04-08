package priv.ana.algorithm;

import java.util.ArrayList;

public class Solution234 {
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

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            integers.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = integers.size() - 1;
        while (left < right) {
            if (!integers.get(left).equals(integers.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
