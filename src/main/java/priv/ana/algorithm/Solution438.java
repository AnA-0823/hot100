package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int[] pCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int sLength = s.length();
        int[] sCount = new int[26];
        int left = 0;
        for (int right = 0; right < sLength; right++) {
            sCount[s.charAt(right) - 'a']++;
            if (Arrays.equals(pCount, sCount)) res.add(left);
            if (right - left + 1 == pLength) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }

    static void main() {
        Solution438 s = new Solution438();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
