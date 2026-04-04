package priv.ana.algorithm;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[(i + k) % len] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, len);
    }
}
