package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0;
        int col = 0;
        int directionIndex = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return res;
    }

    static void main() {
        Solution54 s = new Solution54();
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
