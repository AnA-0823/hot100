package priv.ana.algorithm;

public class Solution1456 {
    public int maxVowels(String s, int k) {
        int length = s.length();
        int count = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            if (check(s.charAt(right))) count++;
            max = Math.max(max, count);
            if (right - left + 1 == k) {
                if (check(s.charAt(left))) count--;
                left++;
            }
        }
        return max;
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
