import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static List<Integer> getSpiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return ans;

        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse → top row
            for (int col = leftCol; col <= rightCol; col++) {
                ans.add(matrix[topRow][col]);
            }
            topRow++;

            // Traverse ↓ right column
            for (int row = topRow; row <= bottomRow; row++) {
                ans.add(matrix[row][rightCol]);
            }
            rightCol--;

            // Traverse ← bottom row
            if (topRow <= bottomRow) {
                for (int col = rightCol; col >= leftCol; col--) {
                    ans.add(matrix[bottomRow][col]);
                }
                bottomRow--;
            }

            // Traverse ↑ left column
            if (leftCol <= rightCol) {
                for (int row = bottomRow; row >= topRow; row--) {
                    ans.add(matrix[row][leftCol]);
                }
                leftCol++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        List<Integer> ans = getSpiralOrder(matrix);

        System.out.println("The Spriral Order is:");

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
