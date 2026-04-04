package priv.ana.algorithm;

import java.util.HashSet;
import java.util.TreeSet;

public class Solution128 {
    // nlogn
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        TreeSet<Integer> integers = new TreeSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        Integer[] array = integers.toArray(new Integer[0]);
        int l = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1) {
                l++;
            } else {
                result = Math.max(result, l);
                l = 1;
            }
        }
        return Math.max(result, l);
    }

    // n
    public int longestConsecutivePlus(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        int longestLength = 0;
        for (int num : integers) {
            if (integers.contains(num - 1)) continue;
            int l = 1;
            int current = num;
            while (integers.contains(current + 1)) {
                l++;
                current++;
            }
            longestLength = Math.max(longestLength, l);
        }
        return longestLength;
    }
}
