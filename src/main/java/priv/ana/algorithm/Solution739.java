package priv.ana.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        // 剩余未出栈的下标元素就是0
        return res;
    }
}
