package priv.ana.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    static class LRUCache {
        private static class LRUCacheNode {
            int key;
            int value;
            LRUCacheNode prev;
            LRUCacheNode next;

            public LRUCacheNode() {
            }

            LRUCacheNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private int size;
        private final LRUCacheNode head;
        private final LRUCacheNode tail;
        private final Map<Integer, LRUCacheNode> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new LRUCacheNode();
            tail = new LRUCacheNode();
            head.next = tail;
            tail.prev = head;
            cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            LRUCacheNode node = cache.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LRUCacheNode node = cache.get(key);
            if (node == null) {
                LRUCacheNode newNode = new LRUCacheNode(key, value);
                addToHead(newNode);
                cache.put(key, newNode);
                size++;
                if (size > capacity) {
                    cache.remove(removeTail().key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private LRUCacheNode removeTail() {
            LRUCacheNode res = tail.prev;
            res.prev.next = tail;
            tail.prev = res.prev;
            return res;
        }

        private void removeNode(LRUCacheNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void addToHead(LRUCacheNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void moveToHead(LRUCacheNode node) {
            removeNode(node);
            addToHead(node);
        }
    }
}
