public class MostWaterContainer {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currArea = minHeight * width;
            maxArea = Math.max(maxArea, currArea);

            // Move the shorter line's pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println("The maximum are is: " + maxArea(height));
    }
}
