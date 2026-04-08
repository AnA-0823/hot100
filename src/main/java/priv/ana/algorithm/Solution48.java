package priv.ana.algorithm;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = matrix[i][j];
            }
        }
        System.arraycopy(res, 0, matrix, 0, m);
    }
}
