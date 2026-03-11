package priv.ana.algorithm;

public class Solution283 {
    // n^2
    public void moveZeroes(int[] nums) {
        int left = nums.length - 1, right = nums.length - 1;
        while (left > 0) {
            left--;
            if (nums[left] == 0) {
                while (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[left + 1];
                    nums[left + 1] = temp;
                    left++;
                }
                right--;
            }
        }
    }

    // n
    public void moveZeroesPlus(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
