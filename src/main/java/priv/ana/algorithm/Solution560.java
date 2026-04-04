package priv.ana.algorithm;

import java.util.HashMap;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) total++;
            }
        }
        return total;
    }

    public int subarraySumPlus(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0, prefix = 0;
        map.put(0, 1);
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) {
                total += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return total;
    }
}
