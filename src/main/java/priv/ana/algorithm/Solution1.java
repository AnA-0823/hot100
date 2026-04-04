package priv.ana.algorithm;

import java.util.HashMap;

public class Solution1 {
    // n^2
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // n
    public int[] twoSumPlus(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = integerIntegerHashMap.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }
        return null;
    }
}
