package priv.ana.algorithm;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            count += num;
            res = Math.max(res, count);
            if (count < 0) count = 0;
        }
        return res;
    }

    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    static void main() {
        Solution53 s = new Solution53();
        System.out.println(s.maxSubArrayDp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
