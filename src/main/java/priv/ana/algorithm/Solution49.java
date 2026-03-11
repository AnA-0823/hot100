package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringListHashMap = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (stringListHashMap.containsKey(key)) {
                stringListHashMap.get(key).add(str);
            } else {
                stringListHashMap.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(stringListHashMap.values());
    }
}
