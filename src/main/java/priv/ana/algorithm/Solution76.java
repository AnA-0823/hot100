package priv.ana.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        int sLength = s.length();
        int left = 0;
        String resStr = "";
        int length = Integer.MAX_VALUE;
        for (int right = 0; right < sLength; right++) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            while (contain(sMap, tMap)) {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    resStr = s.substring(left, right + 1);
                }
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return resStr;
    }

    private boolean contain(Map<Character, Integer> mainMap, Map<Character, Integer> subMap) {
        for (Map.Entry<Character, Integer> entry : subMap.entrySet()) {
            if (entry.getValue() > mainMap.getOrDefault(entry.getKey(), 0)) return false;
        }
        return true;
    }

    static void main() {
        Solution76 sol = new Solution76();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }
}
