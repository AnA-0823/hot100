package priv.ana.algorithm;

import java.util.HashSet;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            integers.add(num);
            max = Math.max(max, num);
        }
        if (max == 0) return 1;
        for (int i = 1; i <= max; i++) if (!integers.contains(i)) return i;
        return max + 1;
    }

    static void main() {
        Solution41 s = new Solution41();
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
