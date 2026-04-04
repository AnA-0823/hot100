package priv.ana.algorithm;

import java.util.HashSet;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < length; right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    static void main() {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
