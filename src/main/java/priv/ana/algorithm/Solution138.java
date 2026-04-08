package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node cur = head;
        Node newListPrehead = new Node(0);
        Node newListCur = newListPrehead;
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            nodeNodeHashMap.put(cur, node);
            newListCur.next = node;
            newListCur = newListCur.next;
            cur = cur.next;
        }
        cur = head;
        newListCur = newListPrehead.next;
        while (cur != null) {
            newListCur.random = nodeNodeHashMap.get(cur.random);
            cur = cur.next;
            newListCur = newListCur.next;
        }
        return newListPrehead.next;
    }
}
