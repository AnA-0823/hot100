package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    do l++;
                    while (l < r && nums[l] == nums[l - 1]);
                    do r--;
                    while (l < r && nums[r] == nums[r + 1]);
                } else if (sum > 0) r--;
                else l++;
            }
        }
        return res;
    }
}
