package priv.ana.algorithm;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int[] m = new int[matrix.length];
        int[] n = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = 1;
                    n[j] = 1;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
