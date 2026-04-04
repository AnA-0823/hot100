package priv.ana.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            queue.add(nums[right]);
            if (right - left + 1 == k) {
                res[left] = queue.peek();
                queue.remove(nums[left]);
                left++;
            }
        }
        return res;
    }

    public int[] maxSlidingWindowPlus(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int left = 0;
        int[] res = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) deque.pollLast();
            deque.addLast(right);
            if (right - left + 1 == k) {
                res[left] = nums[deque.peekFirst()];
                if (deque.peekFirst() == left) deque.pollFirst();
                left++;
            }
        }
        return res;
    }
}
