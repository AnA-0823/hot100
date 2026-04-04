package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= merged.getLast()[1]) {
                int[] remove = merged.removeLast();
                merged.add(new int[]{remove[0], Math.max(remove[1], intervals[i][1])});
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
