import java.util.*;

public class FloodFillImage {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length, cols = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor == newColor)
            return image;

        fill(image, sr, sc, originalColor, newColor);
        return image;
    }

    private static void fill(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;
        if (image[r][c] != color)
            return;

        image[r][c] = newColor;

        fill(image, r + 1, c, color, newColor);
        fill(image, r - 1, c, color, newColor);
        fill(image, r, c + 1, color, newColor);
        fill(image, r, c - 1, color, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Updated Image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
