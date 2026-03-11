package priv.ana.algorithm;

public class Solution887 {
    public int calcF(int k, int t) {
        if (k == 1 || t == 1) return t + 1;
        return calcF(k - 1, t - 1) + calcF(k, t - 1);
    }

    public int superEggDrop(int k, int n) {
        int t = 1;
        while (calcF(k, t) < n + 1) t++;
        return t;
    }
}
