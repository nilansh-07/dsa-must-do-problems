import java.util.*;

public class NearestZeroMatrix {

    public static int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC]) {
                    result[newR][newC] = result[r][c] + 1;
                    queue.add(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);

        System.out.println("Distance to nearest 0:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
